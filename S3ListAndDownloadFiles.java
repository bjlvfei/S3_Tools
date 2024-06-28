package com.amazonaws.s3;

import org.apache.commons.io.IOUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectId;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import com.amazonaws.services.s3.model.GetObjectRequest;

import java.io.FileOutputStream;
import java.io.IOException;

public class S3ListAndDownloadFiles {

    public static void main(String[] args) throws AmazonServiceException, AmazonClientException {
        // Create a client
        AWSCredentials credentials = new BasicAWSCredentials("*********", "*******");
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.CN_NORTH_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        // Get the list of objects in the bucket
        ListObjectsRequest request = new ListObjectsRequest("aems-dev-bucket-0000", null, null, null, null);
        ObjectListing objectListing = s3Client.listObjects(request);

        // Download the objects
        for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            String key = objectSummary.getKey();
            
            System.out.println("File name=" + key);
        }
    }
}
