package com.management.openManagement.models.questionFactory;

import java.util.List;

/**
 * Question factory pattern
 */
public interface Question {

  /**
   * @return full text of question
   */
  String fullText();

  /**
   * @return splited word list of question
   */
  List<String> words();

  /**
   * @return Nodes of decision trees of question
   */
  List<String> nodes();
}
