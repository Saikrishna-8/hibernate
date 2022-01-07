package org.sai;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.sai.hibernate.DAO.FilesDAO;




@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String path = "D:/images/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	

		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		response.getWriter().append("HI  Served at:   ").append(request.getContextPath());

		try {
			List<FileItem> images = upload.parseRequest(request);
			
			
			for (FileItem image : images) {
				String name = image.getName();
				try {
					name = name.substring(name.lastIndexOf("\\") + 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(name);
				new FilesDAO().addFileDetails(new org.sai.hibernate.entity.Files(name));
				image.write(new File(path + name));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("HI  Served at:   ").append(request.getContextPath());
	}

}
