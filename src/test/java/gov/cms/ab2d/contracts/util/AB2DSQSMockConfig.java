package gov.cms.ab2d.contracts.util;

import gov.cms.ab2d.eventclient.clients.SQSEventClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;


import static org.mockito.Mockito.mock;

@TestConfiguration
@EnableAutoConfiguration
public class AB2DSQSMockConfig {

  static {
    System.setProperty("feature.sqs.enabled", "false");
  }

  @MockBean
  SqsAsyncClient amazonSQSAsync;

  @MockBean
  SQSEventClient sQSEventClient;

//  @Bean
//  @Primary
//  public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory() {
//    SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();
//    factory.setAutoStartup(false);
//    return factory;
//  }
//
//  @Bean
//  public QueueMessageHandler messageHandler() {
//    return mock(QueueMessageHandler.class);
//  }

  @Bean("mockAmazonSQS")
  public SqsAsyncClient amazonSQSAsync() {
    return mock(SqsAsyncClient.class);
  }
}