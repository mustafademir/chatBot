package com.management.openManagement.services;

import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {



  public String translate(String text){
    Translate translate = TranslateOptions.getDefaultInstance().getService();
    Translation translation =
      translate.translate(
        text,
        com.google.cloud.translate.Translate.TranslateOption.sourceLanguage("tr"),
        com.google.cloud.translate.Translate.TranslateOption.targetLanguage("en"));
    String aa = "sdfasdf";
    return translation.getTranslatedText();

  }
}
