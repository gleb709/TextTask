package textProgram.service;

import textProgram.entity.Component;
import textProgram.exception.TaskException;

import java.util.Map;

public interface TextService {
    Component sortParagraphByWords(Component textComposite);
    String findSentenceWithLargestWord(Component textComposite);
    void deleteSentences(Component textComposite, int wordSize);
    Map<String, Integer> findRepeatWord(Component textComposite);
    int consonantsCount(Component textComposite);
    int vowelsCount(Component textComposite);

}
