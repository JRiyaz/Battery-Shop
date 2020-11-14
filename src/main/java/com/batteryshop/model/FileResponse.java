package com.batteryshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse {

    private String fileName;

    private String downloadURI;

    private String contentType;

    private Long fileSize;
}
