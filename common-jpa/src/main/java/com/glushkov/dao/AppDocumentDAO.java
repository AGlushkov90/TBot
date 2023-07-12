package com.glushkov.dao;

import com.glushkov.entity.AppDocument;
import com.glushkov.entity.BinaryContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppDocumentDAO extends JpaRepository<AppDocument, Long> {
}
