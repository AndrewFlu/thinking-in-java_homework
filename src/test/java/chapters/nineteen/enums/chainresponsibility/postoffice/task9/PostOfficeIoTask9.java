package chapters.nineteen.enums.chainresponsibility.postoffice.task9;

import chapters.nineteen.enums.chainresponsibility.postoffice.Mail;

import java.util.EnumMap;
import java.util.Map;

import static net.mindview.utils.Print.print;

public class PostOfficeIoTask9 {
    enum MailHandler {GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER}

    public static void handle(Mail9 mail, EnumMap<MailHandler, Handler> em) {
        for (Map.Entry<MailHandler, Handler> e : em.entrySet()) {
            if (e.getValue().handle(mail))
                return;
        }
        print(mail + " is a dead letter");
    }

//    enum MailHandler {
//        GENERAL_DELIVERY {
//            boolean handle(EnumTask9 m) {
//                switch (m.generalDelivery) {
//                    case YES:
//                        print("Using general delivery for: " + m);
//                        return true;
//                    default:
//                        return false;
//                }
//            }
//        },
//        MACHINE_SCAN {
//            boolean handle(EnumTask9 m) {
//                switch (m.scannability) {
//                    case UNSCANNABLE:
//                        return false;
//                    default:
//                        switch (m.address) {
//                            case INCORRECT:
//                                return false;
//                            default:
//                                print("Delivering " + m + " automatically");
//                                return true;
//                        }
//                }
//            }
//        },
//        VISUAL_INSPECTION {
//            boolean handle(EnumTask9 m) {
//                switch (m.readability) {
//                    case ILLEGIBLE:
//                        return false;
//                    default:
//                        switch (m.address) {
//                            case INCORRECT:
//                                return false;
//                            default:
//                                print("Delivering " + m + " normally");
//                                return true;
//                        }
//                }
//            }
//        },
//        RETURN_TO_SENDER {
//            boolean handle(EnumTask9 m) {
//                switch (m.returnAddress) {
//                    case MISSING:
//                        return false;
//                    default:
//                        print("Returning " + m + " to sender");
//                        return true;
//                }
//            }
////        };
//
//        abstract boolean handle(EnumTask9 m);
//    }

//    static void handle(Mail9 m) {
//        for (MailHandler handler : MailHandler.values())
//            if (handler.handle(m))
//                return;
//        print(m + " is a dead letter");
//    }

    public static void main(String[] args) {
        EnumMap<MailHandler, Handler> em = new EnumMap<>(MailHandler.class);
        em.put(MailHandler.GENERAL_DELIVERY, new Handler() {
            @Override
            public boolean handle(Mail9 mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        print("Using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        });
        em.put(MailHandler.MACHINE_SCAN, new Handler() {
            @Override
            public boolean handle(Mail9 mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        print("Delivering " + mail + " automatically");
                        return true;
                }
            }
        });
        em.put(MailHandler.VISUAL_INSPECTION, new Handler() {
            @Override
            public boolean handle(Mail9 mail) {
                switch (mail.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("Delivering " + mail + " normally");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.RETURN_TO_SENDER, new Handler() {
            @Override
            public boolean handle(Mail9 mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        print("Return " + mail + " to sender");
                        return true;
                }
            }
        });
        for (Mail9 mail : Mail9.generator(10)) {
            print(mail.details());
            handle(mail, em);
            print("*****");
        }
    }
}

