package com.management.openManagement.utils;

import com.management.openManagement.dto.NoteDto;

public class NoteGeneralUtilService {

    public int getContentLength(NoteDto note){
        return note.getContent().length();
    }
}
