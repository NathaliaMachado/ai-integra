package br.com.fastofood.ecommerce;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.Arrays;

public class TestIntegration {

    public static void main(String[] args) {

        var userPrompt = "Generate 5 products";
        var systemPrompt = "You are a generator of ficticious product for an e-commerce and you must only generate " +
                "the names of the products";


        var service = new OpenAiService("your_token");

        var completionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                        .messages(Arrays.asList(
                                new ChatMessage(ChatMessageRole.USER.value(), userPrompt),
                                new ChatMessage(ChatMessageRole.SYSTEM.value(), systemPrompt)
                        ))
                        .build();

        service.createChatCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
