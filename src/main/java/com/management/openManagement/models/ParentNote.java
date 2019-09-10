package com.management.openManagement.models;

import com.management.openManagement.dto.NoteDto;
import com.management.openManagement.utils.NoteGeneralUtilService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ParentNote {

    @Autowired      //Bu kullanımla noteGeneralUtilService oluşmamaktadır sebebi ?
    NoteGeneralUtilService noteGeneralUtilService;

    private NoteGeneralUtilService service = new NoteGeneralUtilService();  //Doğru kullanım ?

    public abstract String sayHello();

    public void dene(){
        System.out.println("deneme");
    }

    public int getContentLength(NoteDto note){
        return service.getContentLength(note);
    }

}
