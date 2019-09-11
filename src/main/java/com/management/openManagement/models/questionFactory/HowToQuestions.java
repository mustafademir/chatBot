package com.management.openManagement.models.questionFactory;

import java.util.Arrays;
import java.util.List;

public class HowToQuestions implements Question {

  private String fullText;

  private List<String> nodes;

  @Override
  public String fullText() {
    return fullText;
  }

  @Override
  public List<String> words() {
    return Arrays.asList(fullText.split(" "));
  }

  @Override
  public List<String> nodes() {
    return null;
  }

  public String getFullText() {
    return fullText;
  }

  public void setFullText(String fullText) {
    this.fullText = fullText;
  }

  public List<String> getNodes() {
    return nodes;
  }

  public void setNodes(List<String> nodes) {
    this.nodes = nodes;
  }
}
