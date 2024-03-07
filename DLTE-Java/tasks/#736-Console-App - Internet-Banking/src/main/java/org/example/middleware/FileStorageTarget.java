package org.example.middleware;

import org.example.remotes.UserDetailRepository;
import org.example.remotes.StorageTarget;

public class FileStorageTarget implements StorageTarget{
    @Override
    public UserDetailRepository getUserDetailRepository() {
        return new UserDetailFileRepository("mybank-userdetail.doc");
    }
}
