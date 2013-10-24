package com.constantcontact.util.http;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.constantcontact.util.http.constants.ProcessorBase;

/**
 * A factory that Builds {@link MultipartBody}.
 * @author csciuto
 *
 */
public class MultipartBuilder {
    
    private static String TWO_HYPHENS = "--";
    private static String CRLF = "\r\n";
    

    /**
     * Creates a {@link MultipartBody} from the provided parts
     * @param textParts Any textual fields except File Name, as it's treated specially.
     * @param fileName The name of the file being sent
     * @param filePart The file to send
     * @throws IOException
     * @return THe constructed Body
     */
    public static MultipartBody buildMultipartBody(Map<String, String> textParts, String fileName, InputStream filePart)
            throws IOException{
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream request = new DataOutputStream(byteArray);

        // Write out the misc. text parts.
        Iterator<Entry<String, String>> iter = textParts.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> pairs = (Map.Entry<String, String>) iter.next();
            String key = pairs.getKey();
            String value = pairs.getValue();

            request.writeBytes(TWO_HYPHENS + ProcessorBase.MULTIPART_BOUNDARY + CRLF);
            request.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"" + CRLF);
            request.writeBytes("Content-Type: text/plain; charset=US-ASCII" + CRLF);
            request.writeBytes("Content-Transfer-Encoding: 8bit" + CRLF + CRLF);
            request.writeBytes(value);
            request.writeBytes(CRLF);
        }

        // Write the file name text part
        request.writeBytes(TWO_HYPHENS + ProcessorBase.MULTIPART_BOUNDARY + CRLF);
        request.writeBytes("Content-Disposition: form-data; name=\"file_name\"" + CRLF);
        request.writeBytes("Content-Type: text/plain; charset=US-ASCII" + CRLF);
        request.writeBytes("Content-Transfer-Encoding: 8bit" + CRLF + CRLF);
        request.writeBytes(fileName);
        request.writeBytes(CRLF);
        
        // Now, we write the file.
        request.writeBytes(TWO_HYPHENS + ProcessorBase.MULTIPART_BOUNDARY + CRLF);

        request.writeBytes("Content-Disposition: form-data; name=\"data\"; filename=\"" + fileName + "\"" + CRLF);
        request.writeBytes("Content-Type: application/octet-stream" + CRLF);
        request.writeBytes("Content-Transfer-Encoding: binary" + CRLF + CRLF);
        
        BufferedInputStream inputStream = new BufferedInputStream(filePart);
        byte[] buff = new byte[1024];
        int bytesRead = inputStream.read(buff);
        while (bytesRead > -1){
            request.write(buff);
            bytesRead = inputStream.read(buff);
        }
        
        request.writeBytes(CRLF);
        request.writeBytes(TWO_HYPHENS + ProcessorBase.MULTIPART_BOUNDARY + TWO_HYPHENS + CRLF);
        
        request.flush();
        request.close();
        
        return new MultipartBody(byteArray.toByteArray());
    }
    
}
