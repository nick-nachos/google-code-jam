package jam.google.repeater;

import java.util.Arrays;

import jam.google.deployment.ProblemSolver;

public final class Solver implements ProblemSolver<TestCase> {

    private static final String IMPOSSIBLE = "Fegla Won";
    
    @Override
    public String solve(TestCase instance) {
        StringBuilder[] words = this.toSBArray(instance.words);
        this.sort(words);
        
        if (this.getDiffCharWordIndex(words) > -1) {
            return IMPOSSIBLE;
        }
        
        int charIndex = 1;
        int actions = 0;
        
        while (!this.isDone(words)) {
            int diffCharCount = this.getDiffCharCount(words, charIndex);
            
            if (diffCharCount == 0) {
                charIndex++;
                continue;
            }
            else if (diffCharCount > 1) {
                return IMPOSSIBLE;
            }
            
            CharAction action = this.decideAddOrRemove(words, charIndex);
            char toCompare = this.getNextCharToCompare(words, charIndex - 1);
            this.performAction(words, toCompare, charIndex, action);
            
            if (action == CharAction.ADD) {
                charIndex++;
            }
            
            actions++;
            this.sort(words);
        }
        
        return Integer.toString(actions);
    }

    private void sort(StringBuilder[] sbArray) {
        Arrays.sort(sbArray, new SBComparator());
    }
    
    private int getDiffCharWordIndex(CharSequence[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            int nextI = i + 1;
            
            if (words[i].charAt(0) != words[nextI].charAt(0)) {
                return nextI;
            }
        }
        
        return -1;
    }
    
    private int getDiffCharCount(CharSequence[] words, int charIndex) {
        int count = 0;
        
        for (int i = 0; i < words.length - 1; i++) {
            char c1 = this.charAt(words[i], charIndex);
            char c2 = this.charAt(words[i + 1], charIndex);
            
            if (c1 != c2) {
                count++;
            }
        }
        
        return count;
    }
    
//    private char diffCountCharAt(CharSequence word, int index) {
//        return word.length() > index ? word.charAt(index) : word.charAt(word.length() - 1);
//    }
    
    private StringBuilder[] toSBArray(String[] array) {
        StringBuilder[] sbArray = new StringBuilder[array.length];
        
        for (int i = 0; i < array.length; i++) {
            sbArray[i] = new StringBuilder(array[i]);
        }
        
        return sbArray;
    }
    
    private boolean isDone(StringBuilder[] words) {
        StringBuilder prev = null;
        SBComparator cmp = new SBComparator();
        
        for (StringBuilder word : words) {
            if (prev != null && cmp.compare(prev, word) != 0) {
                return false;
            }
            
            prev = word;
        }
        
        return true;
    }
    
    private CharAction decideAddOrRemove(StringBuilder[] words, int charIndex) {
        int withAdjucent = 0;
        
        for (int j = 0; j < words.length; j++) {
            StringBuilder word = words[j];
            char c1 = this.charAt(word, charIndex);
            
//            if (c1 != c) {
//                continue;
//            }
            
            char c2 = word.charAt(charIndex - 1);
            
            if (c1 == c2) {
                withAdjucent++;
            }
        }
        
        if (withAdjucent > words.length / 2.0) {
            return CharAction.ADD;
        }
        
        return CharAction.REMOVE;
    }
    
    private void performAction(StringBuilder[] words, char c, int charIndex, CharAction action) {
        int actionCount = 0;
        
        for (StringBuilder word : words) {
            char ch = this.charAt(word, charIndex);
            
            if (action == CharAction.ADD) {
                if (ch != c) {
                    word.insert(charIndex, c);
                    actionCount++;
                }
            }
            else {
                if (ch == c) {
                    word.deleteCharAt(charIndex);
                    actionCount++;
                }
            }
        }
        
        if (actionCount == 0) {
            String msg = String.format("No actions at char index %d, for char %s", charIndex, c);
            throw new IllegalStateException(msg);
        }
    }
    
    private char charAt(CharSequence word, int charIndex) {
        return word.length() > charIndex ? word.charAt(charIndex) : 0;
    }
    
    private char getNextCharToCompare(CharSequence[] words, int charIndex) {
        for (CharSequence word : words) {
            if (word.length() > charIndex) {
                return word.charAt(charIndex);
            }
        }
        
        throw new IllegalStateException();
    }
}
