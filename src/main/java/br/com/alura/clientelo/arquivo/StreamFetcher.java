package br.com.alura.clientelo.arquivo;

import java.io.InputStream;

public class StreamFetcher {
    public InputStream fetchStream(String path) {
        return StreamFetcher.class.getClassLoader().getResourceAsStream(path);
    }
}
