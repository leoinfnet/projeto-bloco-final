package org.acme.notafiscal_worker.service;

import lombok.extern.slf4j.Slf4j;
import org.acme.notafiscal_worker.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class NotaFiscalService {
    public void processar(Pedido pedido){
        int i = new Random().nextInt(1000);
        //log.info("Random: " + i );
        //if(i > 20){
           // try {
                //Thread.sleep(10_000);
            log.info("Gerando nota Fiscal do pedido: " +  pedido);
            throw new RuntimeException("Erro");
            //} catch (InterruptedException e) {
               // throw new RuntimeException(e);
            //}
        //}
    }

}
