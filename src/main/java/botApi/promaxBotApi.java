package botApi;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class promaxBotApi extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "promax_it_registr_bot";
    }

    @Override
    public String getBotToken() {
        return "2065637390:AAFQocaZa-U5rnFsJ5C97boAzsRfLCzztOw";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            String chat_id = update.getMessage().getChatId().toString();

            SendMessage message = new SendMessage()
                    .builder()
                    .chatId(chat_id)
                    .text(message_text)
                    .build();
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
