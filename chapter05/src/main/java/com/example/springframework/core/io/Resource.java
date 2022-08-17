package com.example.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源接口
 */
public interface Resource {

    /**
     * 获取文件输入流，读取文件
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
