/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.auth.SignupAuteticateServices;

import com.authservice.auth.KVS.EntityMatchIdUserKVS;
import com.authservice.auth.KVS.IRepoKvs;
import com.authservice.auth.ResponsePersonalData.ResponsePersonalData;
import com.authservice.auth.campo.entity.Datauser_campo;
import com.authservice.auth.campo.entity.TeNomDec;
import com.authservice.auth.campo.repository.IRepoDataUserCampo;
import com.authservice.auth.factory.entity.Datouser_factory;
import com.authservice.auth.factory.entity.Ofertas;
import com.authservice.auth.factory.repository.IRepoDatoUser;
import com.authservice.auth.models.User;
import com.authservice.auth.payload.request.SignUpFullDataRequest;
import com.authservice.auth.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabriel
 */
@Service
@Transactional
public class SignupService implements ISignupServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IRepoDataUserCampo repocampo;
    @Autowired
    private IRepoDatoUser repofactory;
    @Autowired
    private IRepoKvs repkvs;

    @Override
    public ResponsePersonalData ReturnPersonalData(Long id) {
        ResponsePersonalData dataout = new ResponsePersonalData();
        EntityMatchIdUserKVS data1 = repkvs.findByPkuser(id);//aca obtenemos el id de las entidades Datauser_campo o Datouser_factory del kvs 
        Datauser_campo datcam = new Datauser_campo();
        Datouser_factory datfac = new Datouser_factory();
        if (data1.getTipo().equals("Propietario de Secadero")) {
            System.out.println("entramos en el if de secadero");
            datfac = repofactory.findById(data1.getPkdata()).orElseThrow();
            dataout.setId(datfac.getId());
            dataout.setName(datfac.getName_company());
            dataout.setCellphone(datfac.getTelefono());
            dataout.setCenter(data1.getCenter());
        }

        if (data1.getTipo().equals("Propietario de Campo")) {
            System.out.println(" entramos en el if de campo");
            datcam = repocampo.findById(data1.getPkdata()).orElseThrow();
            dataout.setId(datcam.getId());
            dataout.setName(datcam.getTitulo());
            dataout.setCellphone(datcam.getTelefono());
            dataout.setCenter(data1.getCenter());
        }
        return dataout;
    }

    @Override
    public String CreateUserFullData(User user, SignUpFullDataRequest signUpFull) {
        User data = new User();
        Datouser_factory usrfac = new Datouser_factory();
        Datouser_factory usrfacreturn = new Datouser_factory();
        Datauser_campo usrcam = new Datauser_campo();
        Datauser_campo usrcamretur = new Datauser_campo();
        System.out.println(user.toString());
        System.out.println(signUpFull);
        Set<TeNomDec> te = new HashSet<>();
        Set<Ofertas> ofer = new HashSet<>();

        EntityMatchIdUserKVS kvsUser = new EntityMatchIdUserKVS();

        if (signUpFull.getTipousuerValue().equals("Propietario de Campo")) {

            usrcam.setTelefono(signUpFull.getCelphone());
            usrcam.setTitulo("Campo de " + signUpFull.getName() + " " + signUpFull.getLastname());
            usrcam.setTenominal(te);
            usrcam.setFecha_creacion(signUpFull.getDatebrith());
            usrcamretur = repocampo.save(usrcam);
            data = userRepository.save(user);
            kvsUser.setPkdata(usrcamretur.getId());
            kvsUser.setCenter(user.getCenter());
            kvsUser.setPkuser(data.getId());
            kvsUser.setTipo(signUpFull.getTipousuerValue());
            repkvs.save(kvsUser);

            System.out.println("estamos en el servvi propietario campo");

            return "Usuario creado con exito";

        }
        if (signUpFull.getTipousuerValue().equals("Propietario de Secadero")) {

            usrfac.setFecha_creacion(signUpFull.getDatebrith());
            usrfac.setTelefono(signUpFull.getCelphone());
            usrfac.setName_company(signUpFull.getNameFactory());
            usrfac.setOfertas(ofer);
            usrfacreturn = repofactory.save(usrfac);

            data = userRepository.save(user);

            kvsUser.setPkdata(usrfacreturn.getId());
            kvsUser.setPkuser(data.getId());
            kvsUser.setCenter(user.getCenter());

            kvsUser.setTipo(signUpFull.getTipousuerValue());

            repkvs.save(kvsUser);

            System.out.println("estamos en el servi secadero");
            return "Usuario creado con exito";

        } else {
            return "fail";

            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }
}
