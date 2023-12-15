package com.example.demo;

import com.example.demo.model.PostStyleReq;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

    StyleDao styleDao;

    public StyleService(StyleDao styleDao) {
        this.styleDao = styleDao;
    }

    public int insert(PostStyleReq postStyleReq) {
        return styleDao.insert(postStyleReq);
    }
}
