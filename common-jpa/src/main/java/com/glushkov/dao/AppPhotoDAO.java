package com.glushkov.dao;

import com.glushkov.entity.AppDocument;
import com.glushkov.entity.AppPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppPhotoDAO extends JpaRepository<AppPhoto, Long> {
}
