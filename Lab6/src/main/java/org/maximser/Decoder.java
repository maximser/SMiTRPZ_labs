package org.maximser;

import java.io.*;


public class Decoder extends FilterReader {

        protected Decoder(Reader in) {
            super(in);
        }

        public int read(){
            try {
                return decodeChar(super.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }

        public int decodeChar(int charCode) {
            return (charCode/2);
        }

        public void close() {
            try {
                super.in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
