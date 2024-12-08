package chapters.fifteen.generics.latent.ifnointerface;

import chapters.fifteen.generics.latent.applymethod.SimpleQueue;

import java.util.ArrayList;
import java.util.List;

public class FillTestDrive {
    public static void main(String[] args) {
        List<Contract> contracts = new ArrayList<>();
        Fill.fill(contracts, Contract.class, 4);
        Fill.fill(contracts, TitleTransfer.class, 7);

        for (Contract c : contracts) {
            System.out.println(c);
        }

        SimpleQueue<Contract> sContracts = new SimpleQueue<>();
        // не сработает, т.к. метод fill() принимает производные от Collection, а SimpleQueue — не коллекция
//        Fill.fill(sContracts, Contract.class, 3);
    }
}
