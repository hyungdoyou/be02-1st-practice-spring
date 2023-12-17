package com.example.demo.service;

import com.example.demo.dao.StyleDao;
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
