package com.constantcontact;

import com.constantcontact.ConstantContact;
import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.FileType;
import com.constantcontact.components.library.file.ImageSource;
import com.constantcontact.components.library.file.MyLibraryFile;
import com.constantcontact.components.library.folder.MyLibraryFolder;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.components.library.info.UploadStatus;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.MyLibraryServiceMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Constant Contact Library unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactLibraryTest {

    ConstantContact constantContact;

    @Before
    public void beforeTests(){
        constantContact = Mockito.spy(new ConstantContact("", ""));
        constantContact.setMyLibraryService(new MyLibraryServiceMock());
    }

    /**
     * Tests the methods regarding library folders and files
     *
     */
    @Test
    public void getLibraryInfoTest(){
        try {

            MyLibrarySummary myLibrarySummary = new MyLibrarySummary();

            myLibrarySummary = constantContact.getLibraryInfo();
            verify(constantContact).getLibraryInfo();

            assertNotNull(myLibrarySummary);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getLibraryFolders method from ConstantContact.class
     *
     */
    @Test
    public void getLibraryFoldersTest(){

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getLibraryFolders(null, 1);
            verify(constantContact).getLibraryFolders(null, 1);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the add library folder functionality
     *
     */
    @Test
    public void addLibraryFolderTest(){
        MyLibraryFolder myLibraryFolder = mock(MyLibraryFolder.class);
        try {

            MyLibraryFolder resultMyLibraryFolder = constantContact.addLibraryFolder(myLibraryFolder);
            verify(constantContact).addLibraryFolder(myLibraryFolder);

            assertNotNull(resultMyLibraryFolder);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the addLibraryFolder throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void addLibraryFolderExceptionTest(){
        MyLibraryFolder myLibraryFolder = null;
        try {

            MyLibraryFolder resultMyLibraryFolder = constantContact.addLibraryFolder(myLibraryFolder);
            verify(constantContact).addLibraryFolder(myLibraryFolder);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the add library folder functionality
     *
     */
    @Test
    public void getLibraryFolderTest(){
        String libraryFolederId = "1";

        try {

            MyLibraryFolder myLibraryFolder = new MyLibraryFolder();

            myLibraryFolder = constantContact.getLibraryFolder(libraryFolederId);
            verify(constantContact).getLibraryFolder(libraryFolederId);

            assertNotNull(myLibraryFolder);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getLibraryFolder throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getLibraryFolderExceptionTest(){
        String libraryFolederId = null;

        try {

            MyLibraryFolder myLibraryFolder = new MyLibraryFolder();

            myLibraryFolder = constantContact.getLibraryFolder(libraryFolederId);
            verify(constantContact).getLibraryFolder(libraryFolederId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the updateLibraryFolder method from ConstantContact.class
     *
     */
    @Test
    public void updateLibraryFolderTest(){
        String libraryFolederId = "1";

        try {

            MyLibraryFolder myLibraryFolder = constantContact.getLibraryFolder(libraryFolederId);

            MyLibraryFolder resultMyLibraryFolder = constantContact.updateLibraryFolder(myLibraryFolder, true);
            verify(constantContact).updateLibraryFolder(myLibraryFolder, true);

            assertNotNull(resultMyLibraryFolder);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the updateLibraryFolder throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateLibraryFolderExceptionTest(){
        String libraryFolederId = null;

        try {

            MyLibraryFolder myLibraryFolder = null;

            MyLibraryFolder resultMyLibraryFolder = constantContact.updateLibraryFolder(myLibraryFolder, true);
            verify(constantContact).updateLibraryFolder(myLibraryFolder, true);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the delete library folder functionality
     *
     */
    @Test
    public void deleteLibraryFolderTest(){
        String libraryFolderId = "1";
        try {

            constantContact.deleteLibraryFolder(libraryFolderId);
            verify(constantContact).deleteLibraryFolder(libraryFolderId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the deleteLibraryFolder throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteLibraryFolderExceptionTest(){
        String libraryFolderId = null;
        try {

            constantContact.deleteLibraryFolder(libraryFolderId);
            verify(constantContact).deleteLibraryFolder(libraryFolderId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the add library file functionality
     *
     */
    @Test
    public void addLibraryFileTest(){
        String folderId = "1";

        try {

            BufferedImage bf = new BufferedImage(100,100, BufferedImage.TYPE_INT_RGB);

            File file = new File("test.png");
            String fileName = "fileName";

            ImageIO.write(bf, "png", file);

            String fileDescription = "File description";

            String resultLibraryFile = constantContact.addLibraryFile(file, fileName, fileDescription, FileType.PNG, folderId, ImageSource.MyComputer);
            verify(constantContact).addLibraryFile(file, fileName,  fileDescription, FileType.PNG, folderId, ImageSource.MyComputer);

            assertNotNull(resultLibraryFile);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the get library file functionality
     *
     */
    @Test
    public void getLibraryFileTest(){
        String libraryFileId = "1";

        try {

            MyLibraryFile myLibraryFile = new MyLibraryFile();

            myLibraryFile = constantContact.getLibraryFile(libraryFileId);
            verify(constantContact).getLibraryFile(libraryFileId);

            assertNotNull(myLibraryFile);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getLibraryFile throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getLibraryFileExceptionTest(){
        String libraryFileId = null;

        try {

            MyLibraryFile myLibraryFile = new MyLibraryFile();

            myLibraryFile = constantContact.getLibraryFile(libraryFileId);
            verify(constantContact).getLibraryFile(libraryFileId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getLibraryFiles method from ConstantContact.class
     *
     */
    @Test
    public void getLibraryFilesTest(){

        try {

            ResultSet resultSet = new ResultSet();

            resultSet = constantContact.getLibraryFiles(MyLibraryFile.Type.ALL, ImageSource.MyComputer, null, 1);
            verify(constantContact).getLibraryFiles(MyLibraryFile.Type.ALL, ImageSource.MyComputer, null, 1);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests the get library files functionality
     *
     */
    @Test
    public void getLibraryFilesByFolderTest(){
        String folderId = "1";

        try {

            ResultSet resultLibraryFiles = new ResultSet();

            resultLibraryFiles = constantContact.getLibraryFilesByFolder(folderId, 10);
            verify(constantContact).getLibraryFilesByFolder(folderId, 10);

            assertNotNull(resultLibraryFiles);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the delete library file functionality
     *
     */
    @Test
    public void deleteLibraryFileTest(){
        String fileId = "1";
        try {

            constantContact.deleteLibraryFile(fileId);
            verify(constantContact).deleteLibraryFile(fileId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getLibraryFile throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteLibraryFileExceptionTest(){
        String fileId = null;
        try {

            constantContact.deleteLibraryFile(fileId);
            verify(constantContact).deleteLibraryFile(fileId);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the get library trash functionality
     *
     */
    @Test
    public void getLibraryTrashTest(){

        try {

            ResultSet resultSet = mock(ResultSet.class);

            resultSet = constantContact.getLibraryTrash(MyLibraryFile.Type.ALL, null, 10);
            verify(constantContact).getLibraryTrash(MyLibraryFile.Type.ALL, null, 10);

            assertNotNull(resultSet);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }


    /**
     * Tests the delete library trash functionality
     *
     */
    @Test
    public void deleteLibraryTrashTest(){
        try {

            constantContact.deleteLibraryTrash();
            verify(constantContact).deleteLibraryTrash();

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the update library file functionality
     *
     */
    @Test
    public void updateLibraryFileTest(){
        String libraryFileId = "1";

        try {

            MyLibraryFile myLibraryFile = constantContact.getLibraryFile(libraryFileId);

            MyLibraryFile resultMyLibraryFile= constantContact.updateLibraryFile(myLibraryFile, true);
            verify(constantContact).updateLibraryFile(myLibraryFile, true);

            assertNotNull(resultMyLibraryFile);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests that the getLibraryFile throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void updateLibraryFileExceptionTest(){

        try {

            MyLibraryFile myLibraryFile = null;

            MyLibraryFile resultMyLibraryFile= constantContact.updateLibraryFile(myLibraryFile, true);
            verify(constantContact).updateLibraryFile(myLibraryFile, true);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
            System.out.println(e.getErrorInfo());
        }
    }

    /**
     * Tests the getLibraryFilesUploadStatus method from ConstantContact.class
     *
     */
    @Test
    public void getLibraryFilesUploadStatusTest(){
        String fileId = "1";

        try {

            List<UploadStatus> list = new ArrayList<UploadStatus>();

            list = constantContact.getLibraryFilesUploadStatus(fileId);
            verify(constantContact).getLibraryFilesUploadStatus(fileId);

            assertNotNull(list);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests that the getLibraryFile throws the proper exception
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void getLibraryFilesUploadStatusExceptionTest(){

        try {

            List<UploadStatus> list = new ArrayList<UploadStatus>();

            list = constantContact.getLibraryFilesUploadStatus();
            verify(constantContact).getLibraryFilesUploadStatus();

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the moveLibraryFiles method from ConstantContact.class
     *
     */
    @Test
    public void moveLibraryFilesTest(){
        String folderId = "1";
        List list = new ArrayList();
        list.add("1");

        try {

            List resultList = constantContact.moveLibraryFiles(folderId, list);
            verify(constantContact).moveLibraryFiles(folderId, list);

            assertNotNull(resultList);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

}
