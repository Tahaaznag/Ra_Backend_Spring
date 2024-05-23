package com.bergerlevrault.Remoteassist.Repo;

import com.bergerlevrault.Remoteassist.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<File,Long> {
}
