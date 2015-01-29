import com.constantcontact.ConstantContact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.FileType;
import com.constantcontact.components.library.file.ImageSource;
import com.constantcontact.components.library.file.MyLibraryFile;
import com.constantcontact.components.library.folder.MyLibraryFolder;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;

import static org.junit.Assert.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Constant Contact Library unit test class.<br/>
 *
 * @author ConstantContact
 */
public class ConstantContactLibraryTest {

    private ConstantContact constantContact;
    private String apiKey;
    private String accessToken;

    @Before
    /**
     * Sets the apy key and the access token
     * Instantiates the ConstantContact object that contains tested methods
     *
     */
    public void setKeys()
    {
        this.apiKey = System.getProperty("apiKey");
        this.accessToken = System.getProperty("accessToken");
        constantContact = new ConstantContact(apiKey, accessToken);
    }

    @Test
    /**
     * Tests the methods regarding library folders and files
     *
     */
    public void libraryTests(){
        try {
            MyLibrarySummary myLibrarySummary= constantContact.getLibraryInfo();

            //add library folder
            MyLibraryFolder resultFolder = addLibraryFolder();

            //add library file
            String resultFile = addLibraryFile(resultFolder.getId());

            //get library file
            MyLibraryFile myLibraryFile = getLibraryFile(resultFile);

            //get library files and verify if the new file is there
            ResultSet<MyLibraryFile> resultSet = getLibraryFiles(resultFolder.getId(), myLibraryFile);

            //delete library file
            deleteLibraryFile(myLibraryFile.getId());

            //get library trash and verify if the deleted file is there
            getLibraryTrash(myLibraryFile);

            //delete library trash
            deleteLibraryTrash();

            //add library file
            resultFile = addLibraryFile(resultFolder.getId());
            myLibraryFile = getLibraryFile(resultFile);

            //update library file
            MyLibraryFile updatedLibraryFile = updateLibraryFile(myLibraryFile);
            deleteLibraryFile(updatedLibraryFile.getId());
            deleteLibraryTrash();

            //delete library folder
            deleteLibraryFolder(resultFolder.getId());

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the add library folder functionality
     * @return The created library folder
     *
     */
    public MyLibraryFolder addLibraryFolder(){
        MyLibraryFolder myLibraryFolder = new MyLibraryFolder();
        myLibraryFolder.setName("Test Folder "+(new Date()).toString());
        myLibraryFolder.setLevel(0);
        MyLibraryFolder resultFolder = null;
        try {
            resultFolder = constantContact.addLibraryFolder(myLibraryFolder);

            assertEquals("The name of the created folder is not the expected one", myLibraryFolder.getName(), resultFolder.getName());
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
        return resultFolder;
    }

    /**
     * Tests the delete library folder functionality
     * @param libraryFolderId The Id of the folder to be deleted
     *
     */
    public void deleteLibraryFolder(String libraryFolderId){
        try {
            constantContact.deleteLibraryFolder(libraryFolderId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the add library file functionality
     * @param folderId The Id of the folder to which the file is added
     * @return The Id of the added file
     *
     */
    public String addLibraryFile(String folderId){
        String resultLibraryFile = null;
        try {
            BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            g.drawString("Hello World!!!", 10, 20);
            File file = new File("test.png");
            ImageIO.write(image, "png", file);
            String fileName = "File name";
            String fileDescription = "File description";

            resultLibraryFile = constantContact.addLibraryFile(file, fileName, fileDescription, FileType.PNG, folderId, ImageSource.MyComputer);

            MyLibraryFile myLibraryFile = getLibraryFile(resultLibraryFile);

            assertEquals("The retrieved file name is not the expected one", myLibraryFile.getName(), fileName);
            assertEquals("The retrieved file description is not the expected one", myLibraryFile.getDescription(), fileDescription);
            assertEquals("The retrieved file type is not the expected one", myLibraryFile.getFileType(), FileType.PNG.toString());
            assertEquals("The retrieved file folder is not the expected one", myLibraryFile.getFolderId(), folderId);
            assertEquals("The retrieved file source is not the expected one", myLibraryFile.getSource(), ImageSource.MyComputer);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultLibraryFile;
    }

    /**
     * Tests the get library file functionality
     * @param fileId The Id of the file to be retrieved
     * @return The retrieved file
     *
     */
    public MyLibraryFile getLibraryFile(String fileId){
        MyLibraryFile resultLibraryFile = null;
        try {

            resultLibraryFile= constantContact.getLibraryFile(fileId);
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
        return resultLibraryFile;
    }

    /**
     * Tests the get library files functionality
     * @param folderId The Id of the folder containing the files to be retrieved
     * @param file The file added previously used to test if the folder contains what it should
     * @return The result set containing all files from the specified folder
     *
     */
    public ResultSet<MyLibraryFile> getLibraryFiles(String folderId, MyLibraryFile file){
        ResultSet<MyLibraryFile> resultLibraryFiles = null;
        try {

            resultLibraryFiles = constantContact.getLibraryFilesByFolder(folderId, 10);
            for(int i = 0 ; i< resultLibraryFiles.size() ; i++) {
                if (resultLibraryFiles.get(i).getId().equals(file.getId())) {
                    assertEquals("The name of the file is not the expected one", resultLibraryFiles.get(i).getName(), file.getName());
                }
            }
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
        return resultLibraryFiles;
    }

    /**
     * Tests the delete library file functionality
     * @param fileId The Id of the file to be deleted
     *
     */
    public void deleteLibraryFile(String fileId){
        try {
            constantContact.deleteLibraryFile(fileId);
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the get library trash functionality
     * @param file The file used to verify if the trash contains what it should
     *
     */
    public void getLibraryTrash(MyLibraryFile file){
        ResultSet<MyLibraryFile> resultSet = null;
        try {
            resultSet = constantContact.getLibraryTrash(MyLibraryFile.Type.ALL, null, 10);
            for(int i = 0 ; i<resultSet.size() ; i++){
                if(resultSet.get(i).equals(file.getId())) {
                    assertEquals("The name of the file is not the expected one", resultSet.get(i).getName(), file.getName());
                }
            }
        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }


    /**
     * Tests the delete library trash functionality
     *
     */
    public void deleteLibraryTrash(){
        try {
            constantContact.deleteLibraryTrash();

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the update library file functionality
     * @param myLibraryFile The library file to be updated
     * @return The updated library file
     *
     */
    public MyLibraryFile updateLibraryFile(MyLibraryFile myLibraryFile){
        MyLibraryFile updatedLibraryFile = myLibraryFile;
        updatedLibraryFile.setName(myLibraryFile.getName()+"(Updated)");
        try {
            updatedLibraryFile = constantContact.updateLibraryFile(updatedLibraryFile, true);

            assertEquals("The name of the updated file is not the expected one", updatedLibraryFile.getName(), myLibraryFile.getName());

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
        return updatedLibraryFile;

    }
}
