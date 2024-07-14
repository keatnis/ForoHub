package com.keatnis.forohub.api.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    public DatosDetalleTopico registrar(DatosRegistroTopico datosRegistroTopico) {
         var topico = new Topico(datosRegistroTopico);
         topicoRepository.save(topico);
        System.out.println(topico);
        return new DatosDetalleTopico(topico);
    }
}
