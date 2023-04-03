package com.jfacedetection;  
// basically this is java package 
//package is the collection of the relatively type which is class , interface and etc. also used to  group related class 
//we are using package of j face detection 
import org.opencv.core.Core;
//openCV is a cross - platform library using which we can develop real time computer vision application.
//it mainly focus on image processing .
//we had used openCV in our project which help us in image processing.
import org.opencv.core.Mat;
//now here openCV.core.Mat is class which represent a matrix object which is used to store image 
//generally we used Mat to store the image 
import org.opencv.core.MatOfRect;
//In Java, OpenCV (Open Source Computer Vision) is a library used for computer vision and machine learning applications.
// The OpenCV Java API provides several classes and methods to handle images and video processing.
//MatOfRect is a class in the org.opencv.core package of the OpenCV Java API
//It represents a rectangular region in an image, which is stored in a matrix format called Mat.
//The MatOfRect class is used to store multiple rectangles in an image
import org.opencv.core.Point;
//Import org.opencv.core.Point; is an import statement in Java that allows access to the Point class from the OpenCV library.
//The Point class is a data structure used to represent a 2D point, defined by its x and y coordinates. 
//It is commonly used in computer vision and image processing applications.
import org.opencv.core.Rect;
//Import org.opencv.core.Rect is an import statement in Java for the OpenCV  rect class. 
//This class represents a rectangle, defined by its top-left corner and its bottom-right corner
//It can be used for various operations such as getting the width and height of the rectangle
//determining whether a point is inside the rectangle, and computing the intersection of two rectangles.
import org.opencv.core.Scalar;
//it is used to import the Scalar class from the OpenCV library. 
//The Scalar class is used to represent a 4-element vector
//which is used to represent color, or other values such as vector components. 
//The vector elements are accessed using the get and set methods, and are represented by the elements 0-3. 
import org.opencv.imgcodecs.Imgcodecs;
//Import org.opencv.imgcodecs.Imgcodecs; is a Java class from the OpenCV library which is used for reading and writing images in various formats, 
//such as JPEG, PNG, TIFF, etc. 
//It also provides methods for resizing and converting the image data to different color spaces.
import org.opencv.imgproc.Imgproc;
//Import org.opencv.imgproc.Imgproc is a Java library for image processing operations, 
//including basic image processing operations such as filtering, feature extraction, color space conversion, and more advanced operations 
//such as object detection and tracking. This library is part of the OpenCV project and is used to provide an efficient and intuitive interface for image processing.
import org.opencv.objdetect.CascadeClassifier;
//Import org.opencv.objdetect.CascadeClassifier; is a Java class that is part of the OpenCV library. 
//It is used to detect objects in an image or video by using a cascade of classifiers. 
//The classifiers are trained using a set of positive and negative images and then used to detect objects in new images or video.

public class JFaceDetection {
	//Public class JFaceDetection is a Java library that provides a set of classes and methods for face detection and recognition. 
	//It uses an advanced algorithm to detect, identify and recognize faces in an image. 
	//It can also be used to detect and identify facial features in a larger image. 
	//JFaceDetection can be used in applications such as facial recognition, security and surveillance, biometric identification, and other face-related tasks.

	public static void main(String[] args) {
        //Public static void main(String[] args) is the main method in Java which is the program's starting point. 
		//It is the entry point for the program and is used to initiate the program execution. 
		//The main method is declared as public static void and is named main. 
		//The main method accepts a single argument of type String array which is used to pass the runtime arguments to the program.
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME); is a Java method used to load a shared library at runtime. 
		//It is often used to connect native code libraries, such as OpenCV, to Java applications. 
		//Core.NATIVE_LIBRARY_NAME refers to the name of the native library that is being loaded.
		String imgFile = "images/dhoni.jpg";
		//String imgFile = "images/photo.jpg" is a String variable in Java that stores a file path
		//pointing to the file named "photo.jpg" located in the folder "images".
		Mat src = Imgcodecs.imread(imgFile);
		//Mat src = Imgcodecs.imread(imgFile) is a Java method used to read an image from a file. 
		//It takes a file name as an argument and returns a Mat object that stores the image data.
		String xmlFile = "xml/lbpcascade_frontalface.xml";
		//String xmlFile = "xml/lbpcascade_frontalface.xml"; is a String variable in Java that represents a file path to an XML file. 
		//It is commonly used in face-detection algorithms, as it contains information about facial features that can be used to detect faces in an image.
		CascadeClassifier cc = new CascadeClassifier(xmlFile);
		//CascadeClassifier cc in Java is a class used to create a cascade classifier object. 
		//It takes an XML file as a parameter and uses it to create a cascade classifier object. 
		//This object can then be used to detect objects in images using the Haar cascade object detection algorithm.
		MatOfRect faceDetection = new MatOfRect();
		//MatOfRect faceDetection is a class in the Java OpenCV library that is used to detect faces in an image or video. 
		//It uses a cascade classifier object to detect the faces. 
		//It returns a MatOfRect object which contains all the detected faces in the image/video as a rectangle object.
		cc.detectMultiScale(src, faceDetection);
		//cc.detectMultiScale(src, faceDetection) is a Java method used to detect faces in an image. 
		//It takes two arguments – the source image (src) and an instance of the Cascades face detector class (faceDetection). 
		//The method returns a list of Rect objects containing the coordinates of detected faces.
		System.out.println(String.format("Detected faces: %d", faceDetection.toArray().length));
		//This is a Java statement that prints out the number of detected faces in the faceDetection array. 
		//The "%d" in the String.format() method indicates that the length of the faceDetection array should be printed as an integer.
		for(Rect rect: faceDetection.toArray()) {
        //This is a for loop that iterates through an array of Rect objects, which are typically used to represent rectangular regions in an image. 
		//The loop is looping through the array of Rect objects and performing the same action on each individual element of the array.
			
			Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height) , new Scalar(0, 0, 255), 3);
		}
		//is a Java OpenCV function used to draw a rectangle on an image (src) with the specified coordinates (rect.x, rect.y), width (rect.width) and height (rect.height). 
		//The color of the rectangle is red (0, 0, 255) and the line thickness is 3.
		Imgcodecs.imwrite("images/dhoni_out.jpg", src);
		//Imgcodecs.imwrite("images/photo_out.jpg", src); is a method in Java that writes an image stored in the src buffer to the specified file path. 
		//It takes as parameters the file path and the source buffer.
		System.out.println("Image Detection Finished");
	}
}

//System.out.println("Image Detection Finished"); is a Java statement that prints the string "Image Detection Finished" to the console.
//Face detection is a computer technology used for identifying or verifying a person from a digital image or video frame. It is generally used in security systems and can be compared to other biometrics such as fingerprint or eye iris recognition systems.
//Face detection is a popular project for computer vision applications. It can be used for security systems, biometric authentication, and even in robotics.
//Java is a popular programming language that can be used to create face detection applications. Several libraries are available to help developers build their applications, such as JavaCV, OpenCV, and JavaML. Each library provides various features that can be used to create a face detection application.
//To create a face detection application in Java, you will need to have basic knowledge of the language and the libraries mentioned above. You will also need to know how to use the camera and capture images in Java.
//Once you have the basic knowledge, you can begin to create your application. First, you will need to decide on the type of application you want to build. This can be anything from a simple security application to a more advanced facial recognition system.
//Once you have decided on the type of application, you can begin to build the features that you need. This will

