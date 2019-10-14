package dataproviders;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynamoDBDataProvider<T> implements IDBDataProvider<T> {
    private DynamoDBMapper dynamoDBMapper;

    public DynamoDBDataProvider() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                "AKIAW2QHP4IZEWYBKOUH",
                "oqDEl3JhiGMADrpDefZMR9ouRkZSdDG+se+rdcY1");
        // This is comment for DynamoDBDataProvider.
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        this.dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

    @Override
    public void insert(T item) {
        this.dynamoDBMapper.save(item);
    }
}
