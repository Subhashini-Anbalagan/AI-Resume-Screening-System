package com.resume.resume_screening_system.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public String uploadResume(File file) throws Exception {

        Map uploadResult =
                cloudinary.uploader().upload(
                        file,
                        ObjectUtils.asMap(
                                "resource_type",
                                "raw"
                        )
                );

        return uploadResult
                .get("secure_url")
                .toString();
    }
}