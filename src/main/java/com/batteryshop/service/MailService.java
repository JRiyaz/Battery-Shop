package com.batteryshop.service;

import lombok.AllArgsConstructor;

//@Service
@AllArgsConstructor
public class MailService {

//    private final JavaMailSender sender;
//    private final Configuration config;
//
//    public MailResponse sendEmail(MailRequest request, Map<String, Object> model) {
//        var filePath = "src/main/resources/file-handling";
//        MailResponse response = new MailResponse();
//        MimeMessage message = sender.createMimeMessage();
//        try {
//            // set mediaType
//            MimeMessageHelper helper = new MimeMessageHelper(message,
//                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                    StandardCharsets.UTF_8.name());
//            // add attachment
//            helper.addAttachment("work-1.jpg", new ClassPathResource("static/img/work-1.jpg"));
//
//            Template t = config.getTemplate("email-template.ftl");
//            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
//
//            helper.setTo(request.getTo());
//            helper.setText(html, true);
//            helper.setSubject(request.getSubject());
//            helper.setFrom(request.getFrom());
//            sender.send(message);
//
//            response.setMessage("mail send to : " + request.getTo());
//            response.setStatus(Boolean.TRUE);
//
//        } catch (MessagingException | IOException | TemplateException e) {
//            response.setMessage("Mail Sending failure : " + e.getMessage());
//            response.setStatus(Boolean.FALSE);
//        }
//        return response;
//    }
}

