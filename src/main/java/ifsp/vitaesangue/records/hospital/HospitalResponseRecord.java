package ifsp.vitaesangue.records.hospital;

import ifsp.vitaesangue.model.Estabelecimento;
import ifsp.vitaesangue.model.Hospital;
import ifsp.vitaesangue.model.TipoHospital;

public record HospitalResponseRecord(Long id,String cnes, TipoHospital tipo,  String diretorResponsavel, Estabelecimento estabelecimento) {
	public HospitalResponseRecord(Hospital hospital){
        this(hospital.getId(), hospital.getCnes(), hospital.getTipo(), hospital.getDiretorResponsavel(), hospital.getEstabelecimento());
    }
}
