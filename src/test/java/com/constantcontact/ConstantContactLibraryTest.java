package com.constantcontact;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.components.library.file.ImageSource;
import com.constantcontact.components.library.file.MyLibraryFile;
import com.constantcontact.components.library.folder.MyLibraryFolder;
import com.constantcontact.components.library.info.MoveResults;
import com.constantcontact.components.library.info.MyLibrarySummary;
import com.constantcontact.components.library.info.UploadStatus;
import com.constantcontact.exceptions.service.ConstantContactServiceException;
import com.constantcontact.mockup.ConstantContactFactoryMock;
import com.constantcontact.services.library.IMyLibraryService;
import com.constantcontact.util.http.MultipartBody;
import com.constantcontact.util.http.MultipartBuilder;

/**
 * Constant Contact Library unit test class.<br/>
 *
 * @author ConstantContact
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstantContactLibraryTest {

	private ConstantContactFactoryMock constantContactFactory;
    private IMyLibraryService myLibraryService;
    
    @Before
    public void beforeTests(){
    	constantContactFactory = Mockito.spy(new ConstantContactFactoryMock("",""));
    	myLibraryService = constantContactFactory.createMyLibraryService();
    } 

    /**
     * Tests the methods regarding library folders and files
     *
     */
    @Test
    public void getLibraryInfoTest(){
        try {

            MyLibrarySummary myLibrarySummary = new MyLibrarySummary();

            myLibrarySummary = myLibraryService.getLibraryInfo();
            verify(myLibraryService).getLibraryInfo();

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

            resultSet = myLibraryService.getLibraryFolders(null, 1);
            verify(myLibraryService).getLibraryFolders(null, 1);

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

            MyLibraryFolder resultMyLibraryFolder = myLibraryService.addLibraryFolder(myLibraryFolder);
            verify(myLibraryService).addLibraryFolder(myLibraryFolder);

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

            MyLibraryFolder resultMyLibraryFolder = myLibraryService.addLibraryFolder(myLibraryFolder);
            verify(myLibraryService).addLibraryFolder(myLibraryFolder);

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

            myLibraryFolder = myLibraryService.getLibraryFolder(libraryFolederId);
            verify(myLibraryService).getLibraryFolder(libraryFolederId);

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

            myLibraryFolder = myLibraryService.getLibraryFolder(libraryFolederId);
            verify(myLibraryService).getLibraryFolder(libraryFolederId);

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

            MyLibraryFolder myLibraryFolder = myLibraryService.getLibraryFolder(libraryFolederId);

            MyLibraryFolder resultMyLibraryFolder = myLibraryService.updateLibraryFolder(myLibraryFolder, true);
            verify(myLibraryService).updateLibraryFolder(myLibraryFolder, true);

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

            MyLibraryFolder resultMyLibraryFolder = myLibraryService.updateLibraryFolder(myLibraryFolder, true);
            verify(myLibraryService).updateLibraryFolder(myLibraryFolder, true);

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

        	myLibraryService.deleteLibraryFolder(libraryFolderId);
            verify(myLibraryService).deleteLibraryFolder(libraryFolderId);

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

        	myLibraryService.deleteLibraryFolder(libraryFolderId);
            verify(myLibraryService).deleteLibraryFolder(libraryFolderId);

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

            Map<String,String> textParts = new HashMap<String,String>();
            
            textParts.put("description", fileDescription);
            textParts.put("file_type", file.toString());
            textParts.put("folder_id", folderId);
            textParts.put("source", bf.toString());
            
            InputStream fileStream = new FileInputStream(file);
            
            MultipartBody request = MultipartBuilder.buildMultipartBody(textParts, fileName, fileStream);
           
            String resultLibraryFile = myLibraryService.addLibraryFile(request);
            verify(myLibraryService).addLibraryFile(request);

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

            myLibraryFile = myLibraryService.getLibraryFile(libraryFileId);
            verify(myLibraryService).getLibraryFile(libraryFileId);

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

            myLibraryFile = myLibraryService.getLibraryFile(libraryFileId);
            verify(myLibraryService).getLibraryFile(libraryFileId);

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

            resultSet = myLibraryService.getLibraryFiles(MyLibraryFile.Type.ALL, ImageSource.MyComputer, null, 1);
            verify(myLibraryService).getLibraryFiles(MyLibraryFile.Type.ALL, ImageSource.MyComputer, null, 1);

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

            resultLibraryFiles = myLibraryService.getLibraryFilesByFolder(folderId, 10);
            verify(myLibraryService).getLibraryFilesByFolder(folderId, 10);

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

        	myLibraryService.deleteLibraryFile(fileId);
            verify(myLibraryService).deleteLibraryFile(fileId);

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

        	myLibraryService.deleteLibraryFile(fileId);
            verify(myLibraryService).deleteLibraryFile(fileId);

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

            resultSet = myLibraryService.getLibraryTrash(MyLibraryFile.Type.ALL, null, 10);
            verify(myLibraryService).getLibraryTrash(MyLibraryFile.Type.ALL, null, 10);

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

        	myLibraryService.deleteLibraryTrash();
            verify(myLibraryService).deleteLibraryTrash();

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

            MyLibraryFile myLibraryFile = myLibraryService.getLibraryFile(libraryFileId);

            MyLibraryFile resultMyLibraryFile= myLibraryService.updateLibraryFile(myLibraryFile, true);
            verify(myLibraryService).updateLibraryFile(myLibraryFile, true);

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

            MyLibraryFile resultMyLibraryFile= myLibraryService.updateLibraryFile(myLibraryFile, true);
            verify(myLibraryService).updateLibraryFile(myLibraryFile, true);

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

            list = myLibraryService.getLibraryFilesUploadStatus(fileId);
            verify(myLibraryService).getLibraryFilesUploadStatus(fileId);

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

            list = myLibraryService.getLibraryFilesUploadStatus();
            verify(myLibraryService).getLibraryFilesUploadStatus();

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
        List<String> list = new ArrayList<String>();
        list.add("1");

        StringBuilder body = new StringBuilder("[");
        body.append("\"").append(list.get(0)).append("\"");
        for (int i=1;i<list.size();i++){
        	body.append(",").append("\"").append(list.get(i)).append("\"");
        }
        body.append("]");
        
        try {

        	List<MoveResults> resultList = myLibraryService.moveLibraryFiles(folderId, body.toString());
            verify(myLibraryService).moveLibraryFiles(folderId, body.toString());

            assertNotNull(resultList);

        } catch (ConstantContactServiceException e) {
            e.printStackTrace();
        }
    }

}
