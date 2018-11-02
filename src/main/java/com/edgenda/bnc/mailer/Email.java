package com.edgenda.bnc.mailer;

import com.google.gson.Gson;

public class Email {

  private final String senderEmail;
  private final String senderName;
  private final String receiverEmail;
  private final String receiverName;
  private final String subject;
  private final String body;

  public Email(
          String senderEmail, String senderName, String receiverEmail,
          String receiverName, String subject, String body
  ) {
    this.senderEmail = senderEmail;
    this.senderName = senderName;
    this.receiverEmail = receiverEmail;
    this.receiverName = receiverName;
    this.subject = subject;
    this.body = body;
  }

  public String getSenderEmail() {
    return senderEmail;
  }

  public String getSenderName() {
    return senderName;
  }

  public String getReceiverEmail() {
    return receiverEmail;
  }

  public String getReceiverName() {
    return receiverName;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  String toJson() {
    final Gson gson = new Gson();
    return gson.toJson(this);
  }
}
