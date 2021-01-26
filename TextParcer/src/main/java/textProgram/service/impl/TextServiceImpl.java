package textProgram.service.impl;

import textProgram.comparator.SortParagraphsByWords;
import textProgram.entity.Component;
import textProgram.entity.ComponentType;
import textProgram.entity.impl.Composite;
import textProgram.service.TextService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashSet;


public class TextServiceImpl implements TextService {

    private static final String CONSONANT = "[aeiouyAEIOUY]";
    private static final String VOWEL = "[BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz]";
    @Override
    public Component sortParagraphByWords(Component textComposite) {
        ArrayList<Component> components = new ArrayList<>();
        for(int i = 0; i < textComposite.getComponentsSize(); i++){
            components.add(textComposite.getComponent(i));
        }
        components.sort(new SortParagraphsByWords());
        Component newTextComposite = new Composite();
        newTextComposite.setType(ComponentType.TEXT);
        for (int i = 0; i < textComposite.getComponentsSize(); i++) {
            newTextComposite.add(components.get(i));
        }
        return newTextComposite;
    }

    @Override
    public String findSentenceWithLargestWord(Component textComposite) {
        String largestWord = "";
        String sentenceWithLargestWord = "";
        for(int i = 0; i < textComposite.getComponentsSize(); i++){
            Component paragraph = textComposite.getComponent(i);
            for(int j = 0; j < paragraph.getComponentsSize(); j++){
                Component sentence = paragraph.getComponent(j);
                for(int x = 0; x < sentence.getComponentsSize(); x++){
                    if(sentence.getComponent(x).getComponentsSize() > largestWord.length()){
                        largestWord = sentence.getComponent(x).toString();
                        sentenceWithLargestWord = paragraph.getComponent(j).toString();
                    }
                }
            }
        }
        return sentenceWithLargestWord;
    }

    @Override
    public void deleteSentences(Component textComposite, int wordSize) {
        for(int i = 0; i < textComposite.getComponentsSize(); i++){
            Component paragraph = textComposite.getComponent(i);
            for(int j = 0; j < paragraph.getComponentsSize(); j++){
                Component sentence = paragraph.getComponent(j);
                if(sentence.getComponentsSize() < wordSize){
                    paragraph.remove(sentence);
                    j--;
                }
            }
            if(paragraph.getComponentsSize() == 0){
                textComposite.remove(paragraph);
                i--;
            }
        }
    }

    @Override
    public Map<String, Integer> findRepeatWord(Component textComposite) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < textComposite.getComponentsSize(); i++) {
            Component paragraph = textComposite.getComponent(i);
            for (int j = 0; j < paragraph.getComponentsSize(); j++) {
                Component sentence = paragraph.getComponent(j);
                for (int x = 0; x < sentence.getComponentsSize(); x++) {
                    words.add(sentence.getComponent(x).toString().toLowerCase());
                }
            }
        }
        Set<String> uniqueWords = new HashSet<>(words);
        for (String word : uniqueWords) {
            if(Collections.frequency(words, word) > 1) {
                map.put(word, Collections.frequency(words, word));
            }
        }
        return map;
    }

    @Override
    public int consonantsCount(Component textComposite) {
        int consonantCount = 0;
        for(int i = 0; i < textComposite.getComponentsSize(); i++) {
            Component paragraph = textComposite.getComponent(i);
            for (int j = 0; j < paragraph.getComponentsSize(); j++) {
                Component sentence = paragraph.getComponent(j);
                for (int x = 0; x < sentence.getComponentsSize(); x++) {
                    Component word = sentence.getComponent(x);
                    for (int y = 0; y < word.getComponentsSize(); y++) {
                        if (word.getComponent(y).toString().matches(CONSONANT)) {
                            consonantCount++;
                        }
                    }
                }
            }
        }
        return consonantCount;
    }

    @Override
    public int vowelsCount(Component textComposite) {
        int vowelCount = 0;
        for(int i = 0; i < textComposite.getComponentsSize(); i++) {
            Component paragraph = textComposite.getComponent(i);
            for (int j = 0; j < paragraph.getComponentsSize(); j++) {
                Component sentence = paragraph.getComponent(j);
                for (int x = 0; x < sentence.getComponentsSize(); x++) {
                    Component word = sentence.getComponent(x);
                    for (int y = 0; y < word.getComponentsSize(); y++) {
                        if (word.getComponent(y).toString().matches(VOWEL)) {
                            vowelCount++;
                        }
                    }
                }
            }
        }
        return vowelCount;

    }
}
