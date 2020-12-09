package app.pojo;





import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;



@JsonIgnoreProperties(ignoreUnknown = true)
public class FtsTransaction {

    @JsonProperty("Serial")
    private long Serial;
    @JsonProperty("FechaAperturaTurno")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date FechaAperturaTurno;
    @JsonProperty("IdPeaje")
    private int IdPeaje;
    @JsonProperty("CarrilAperturaTurno")
    private int CarrilAperturaTurno;
    @JsonProperty("CarrilTab")
    private int CarrilTab;
    @JsonProperty("CodigoOperador")
    private String CodigoOperador;
    @JsonProperty("NombreOperador")
    private String NombreOperador;
    @JsonProperty("ApellidoOperador")
    private String ApellidoOperador;
    @JsonProperty("Cargo")
    private String Cargo;
    @JsonProperty("TurnoTab")
    private int TurnoTab;
    @JsonProperty("FechaTab")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date FechaTab;
    @JsonProperty("CategoriaTab")
    private int CategoriaTab;
    @JsonProperty("TipoEjeTab")
    private int TipoEjeTab;
    @JsonProperty("CantidadEjesTab")
    private int CantidadEjesTab;
    @JsonProperty("TipoPagoTab")
    private int TipoPagoTab;
    @JsonProperty("TipoEspecialTab")
    private int TipoEspecialTab;
    @JsonProperty("TipoPagoEjeTab")
    private int TipoPagoEjeTab;
    @JsonProperty("PrecioTab")
    private float PrecioTab;
    @JsonProperty("PrecioEjesTab")
    private float PrecioEjesTab;
    @JsonProperty("PlacaDigitada")
    private String PlacaDigitada;
    @JsonProperty("SentidoTab")
    private int SentidoTab;
    @JsonProperty("TiqueteTab")
    private String TiqueteTab;
    @JsonProperty("IdFoto")
    private String IdFoto;
    @JsonProperty("Tipo_Dispositivo")
    private int Tipo_Dispositivo;
    @JsonProperty("Id_Dispositivo")
    private String Id_Dispositivo;
    @JsonProperty("Dato_Saldo")
    private float Dato_Saldo;
    @JsonProperty("Dato_Cat")
    private int Dato_Cat;
    @JsonProperty("Dato_Nombre")
    private String Dato_Nombre;
    @JsonProperty("Dato_Apellido")
    private String Dato_Apellido;
    @JsonProperty("Dato_Cedula")
    private String Dato_Cedula;
    @JsonProperty("Dato_Placa")
    private String Dato_Placa;
    @JsonProperty("Dato_Color")
    private String Dato_Color;
    @JsonProperty("Dato_Tp_Invias")
    private String Dato_Tp_Invias;
    @JsonProperty("FechaDac")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date FechaDac;
    @JsonProperty("CatDac")
    private int CatDac;
    @JsonProperty("EjesDac")
    private int EjesDac;
    @JsonProperty("EjesAdDac")
    private int EjesAdDac;
    @JsonProperty("EjesDoblesDac")
    private int EjesDoblesDac;
    @JsonProperty("SentidoDac")
    private int SentidoDac;
    @JsonProperty("Datos_Ciclo")
    private String Datos_Ciclo;
    @JsonProperty("Estado_peanas")
    private String Estado_peanas;
    @JsonProperty("SegVial")
    private float SegVial;
    @JsonProperty("TipoTurno")
    private int TipoTurno;
    @JsonProperty("Conciliado")
    private int Conciliado;
    @JsonProperty("NConciliacion")
    private String NConciliacion;
    @JsonProperty("CODIGO_VERIFICACION")
    private String CODIGO_VERIFICACION;
    @JsonProperty("Procesado1")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date Procesado1;
    @JsonProperty("Procesado2")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date Procesado2;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("anrp_placa")
    private String anrp_placa;
    @JsonProperty("anrp_confiabilidad")
    private float anrp_confiabilidad;
    @JsonProperty("anrp_json_info")
    private String anrp_json_info;
    @JsonProperty("TarifaPlena")
    private float TarifaPlena;
    @JsonProperty("cliente_uuid")
    private String cliente_uuid;
    @JsonProperty("clave_acceso")
    private String clave_acceso;

    private String tableName;

    public FtsTransaction() {
    }

    public FtsTransaction(long Serial, Date FechaAperturaTurno, int IdPeaje, int CarrilAperturaTurno, int CarrilTab, String CodigoOperador, String NombreOperador, String ApellidoOperador, String Cargo, int TurnoTab, Date FechaTab, int CategoriaTab, int TipoEjeTab, int CantidadEjesTab, int TipoPagoTab, int TipoEspecialTab, int TipoPagoEjeTab, float PrecioTab, float PrecioEjesTab, String PlacaDigitada, int SentidoTab, String TiqueteTab, String IdFoto, int Tipo_Dispositivo, String Id_Dispositivo, float Dato_Saldo, int Dato_Cat, String Dato_Nombre, String Dato_Apellido, String Dato_Cedula, String Dato_Placa, String Dato_Color, String Dato_Tp_Invias, Date FechaDac, int CatDac, int EjesDac, int EjesAdDac, int EjesDoblesDac, int SentidoDac, String Datos_Ciclo, String Estado_peanas, float SegVial, int TipoTurno, int Conciliado, String NConciliacion, String CODIGO_VERIFICACION, Date Procesado1, Date Procesado2, String uuid, String anrp_placa, float anrp_confiabilidad, String anrp_json_info, float TarifaPlena, UUID cliente_uuid) {
        this.Serial = Serial;
        this.FechaAperturaTurno = FechaAperturaTurno;
        this.IdPeaje = IdPeaje;
        this.CarrilAperturaTurno = CarrilAperturaTurno;
        this.CarrilTab = CarrilTab;
        this.CodigoOperador = CodigoOperador;
        this.NombreOperador = NombreOperador;
        this.ApellidoOperador = ApellidoOperador;
        this.Cargo = Cargo;
        this.TurnoTab = TurnoTab;
        this.FechaTab = FechaTab;
        this.CategoriaTab = CategoriaTab;
        this.TipoEjeTab = TipoEjeTab;
        this.CantidadEjesTab = CantidadEjesTab;
        this.TipoPagoTab = TipoPagoTab;
        this.TipoEspecialTab = TipoEspecialTab;
        this.TipoPagoEjeTab = TipoPagoEjeTab;
        this.PrecioTab = PrecioTab;
        this.PrecioEjesTab = PrecioEjesTab;
        this.PlacaDigitada = PlacaDigitada;
        this.SentidoTab = SentidoTab;
        this.TiqueteTab = TiqueteTab;
        this.IdFoto = IdFoto;
        this.Tipo_Dispositivo = Tipo_Dispositivo;
        this.Id_Dispositivo = Id_Dispositivo;
        this.Dato_Saldo = Dato_Saldo;
        this.Dato_Cat = Dato_Cat;
        this.Dato_Nombre = Dato_Nombre;
        this.Dato_Apellido = Dato_Apellido;
        this.Dato_Cedula = Dato_Cedula;
        this.Dato_Placa = Dato_Placa;
        this.Dato_Color = Dato_Color;
        this.Dato_Tp_Invias = Dato_Tp_Invias;
        this.FechaDac = FechaDac;
        this.CatDac = CatDac;
        this.EjesDac = EjesDac;
        this.EjesAdDac = EjesAdDac;
        this.EjesDoblesDac = EjesDoblesDac;
        this.SentidoDac = SentidoDac;
        this.Datos_Ciclo = Datos_Ciclo;
        this.Estado_peanas = Estado_peanas;
        this.SegVial = SegVial;
        this.TipoTurno = TipoTurno;
        this.Conciliado = Conciliado;
        this.NConciliacion = NConciliacion;
        this.CODIGO_VERIFICACION = CODIGO_VERIFICACION;
        this.Procesado1 = Procesado1;
        this.Procesado2 = Procesado2;
        this.uuid = uuid;
        this.anrp_placa = anrp_placa;
        this.anrp_confiabilidad = anrp_confiabilidad;
        this.anrp_json_info = anrp_json_info;
        this.TarifaPlena = TarifaPlena;
    }

    public long getSerial() {
        return this.Serial;
    }

    public void setSerial(long Serial) {
        this.Serial = Serial;
    }

    public Date getFechaAperturaTurno() {
        return this.FechaAperturaTurno;
    }

    public void setFechaAperturaTurno(Date FechaAperturaTurno) {
        this.FechaAperturaTurno = FechaAperturaTurno;
    }

    public int getIdPeaje() {
        return this.IdPeaje;
    }

    public void setIdPeaje(int IdPeaje) {
        this.IdPeaje = IdPeaje;
    }

    public int getCarrilAperturaTurno() {
        return this.CarrilAperturaTurno;
    }

    public void setCarrilAperturaTurno(int CarrilAperturaTurno) {
        this.CarrilAperturaTurno = CarrilAperturaTurno;
    }

    public int getCarrilTab() {
        return this.CarrilTab;
    }

    public void setCarrilTab(int CarrilTab) {
        this.CarrilTab = CarrilTab;
    }

    public String getCodigoOperador() {
        return this.CodigoOperador;
    }

    public void setCodigoOperador(String CodigoOperador) {
        this.CodigoOperador = CodigoOperador;
    }

    public String getNombreOperador() {
        return this.NombreOperador;
    }

    public void setNombreOperador(String NombreOperador) {
        this.NombreOperador = NombreOperador;
    }

    public String getApellidoOperador() {
        return this.ApellidoOperador;
    }

    public void setApellidoOperador(String ApellidoOperador) {
        this.ApellidoOperador = ApellidoOperador;
    }

    public String getCargo() {
        return this.Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getTurnoTab() {
        return this.TurnoTab;
    }

    public void setTurnoTab(int TurnoTab) {
        this.TurnoTab = TurnoTab;
    }

    public Date getFechaTab() {
        return this.FechaTab;
    }

    public void setFechaTab(Date FechaTab) {
        this.FechaTab = FechaTab;
    }

    public int getCategoriaTab() {
        return this.CategoriaTab;
    }

    public void setCategoriaTab(int CategoriaTab) {
        this.CategoriaTab = CategoriaTab;
    }

    public int getTipoEjeTab() {
        return this.TipoEjeTab;
    }

    public void setTipoEjeTab(int TipoEjeTab) {
        this.TipoEjeTab = TipoEjeTab;
    }

    public int getCantidadEjesTab() {
        return this.CantidadEjesTab;
    }

    public void setCantidadEjesTab(int CantidadEjesTab) {
        this.CantidadEjesTab = CantidadEjesTab;
    }

    public int getTipoPagoTab() {
        return this.TipoPagoTab;
    }

    public void setTipoPagoTab(int TipoPagoTab) {
        this.TipoPagoTab = TipoPagoTab;
    }

    public int getTipoEspecialTab() {
        return this.TipoEspecialTab;
    }

    public void setTipoEspecialTab(int TipoEspecialTab) {
        this.TipoEspecialTab = TipoEspecialTab;
    }

    public int getTipoPagoEjeTab() {
        return this.TipoPagoEjeTab;
    }

    public void setTipoPagoEjeTab(int TipoPagoEjeTab) {
        this.TipoPagoEjeTab = TipoPagoEjeTab;
    }

    public float getPrecioTab() {
        return this.PrecioTab;
    }

    public void setPrecioTab(float PrecioTab) {
        this.PrecioTab = PrecioTab;
    }

    public float getPrecioEjesTab() {
        return this.PrecioEjesTab;
    }

    public void setPrecioEjesTab(float PrecioEjesTab) {
        this.PrecioEjesTab = PrecioEjesTab;
    }

    public String getPlacaDigitada() {
        return this.PlacaDigitada;
    }

    public void setPlacaDigitada(String PlacaDigitada) {
        this.PlacaDigitada = PlacaDigitada;
    }

    public int getSentidoTab() {
        return this.SentidoTab;
    }

    public void setSentidoTab(int SentidoTab) {
        this.SentidoTab = SentidoTab;
    }

    public String getTiqueteTab() {
        return this.TiqueteTab;
    }

    public void setTiqueteTab(String TiqueteTab) {
        this.TiqueteTab = TiqueteTab;
    }

    public String getIdFoto() {
        return this.IdFoto;
    }

    public void setIdFoto(String IdFoto) {
        this.IdFoto = IdFoto;
    }

    public int getTipo_Dispositivo() {
        return this.Tipo_Dispositivo;
    }

    public void setTipo_Dispositivo(int Tipo_Dispositivo) {
        this.Tipo_Dispositivo = Tipo_Dispositivo;
    }

    public String getId_Dispositivo() {
        return this.Id_Dispositivo;
    }

    public void setId_Dispositivo(String Id_Dispositivo) {
        this.Id_Dispositivo = Id_Dispositivo;
    }

    public float getDato_Saldo() {
        return this.Dato_Saldo;
    }

    public void setDato_Saldo(float Dato_Saldo) {
        this.Dato_Saldo = Dato_Saldo;
    }

    public int getDato_Cat() {
        return this.Dato_Cat;
    }

    public void setDato_Cat(int Dato_Cat) {
        this.Dato_Cat = Dato_Cat;
    }

    public String getDato_Nombre() {
        return this.Dato_Nombre;
    }

    public void setDato_Nombre(String Dato_Nombre) {
        this.Dato_Nombre = Dato_Nombre;
    }

    public String getDato_Apellido() {
        return this.Dato_Apellido;
    }

    public void setDato_Apellido(String Dato_Apellido) {
        this.Dato_Apellido = Dato_Apellido;
    }

    public String getDato_Cedula() {
        return this.Dato_Cedula;
    }

    public void setDato_Cedula(String Dato_Cedula) {
        this.Dato_Cedula = Dato_Cedula;
    }

    public String getDato_Placa() {
        if (this.Dato_Placa == null) {
            return "";
        }
        return this.Dato_Placa;
    }

    public void setDato_Placa(String Dato_Placa) {
        this.Dato_Placa = Dato_Placa;
    }

    public String getDato_Color() {
        return this.Dato_Color;
    }

    public void setDato_Color(String Dato_Color) {
        this.Dato_Color = Dato_Color;
    }

    public String getDato_Tp_Invias() {
        if (this.Dato_Tp_Invias == null) {
            return "";
        }
        return this.Dato_Tp_Invias;
    }

    public void setDato_Tp_Invias(String Dato_Tp_Invias) {
        this.Dato_Tp_Invias = Dato_Tp_Invias;
    }

    public Date getFechaDac() {
        return this.FechaDac;
    }

    public void setFechaDac(Date FechaDac) {
        this.FechaDac = FechaDac;
    }

    public int getCatDac() {
        return this.CatDac;
    }

    public void setCatDac(int CatDac) {
        this.CatDac = CatDac;
    }

    public int getEjesDac() {
        return this.EjesDac;
    }

    public void setEjesDac(int EjesDac) {
        this.EjesDac = EjesDac;
    }

    public int getEjesAdDac() {
        return this.EjesAdDac;
    }

    public void setEjesAdDac(int EjesAdDac) {
        this.EjesAdDac = EjesAdDac;
    }

    public int getEjesDoblesDac() {
        return this.EjesDoblesDac;
    }

    public void setEjesDoblesDac(int EjesDoblesDac) {
        this.EjesDoblesDac = EjesDoblesDac;
    }

    public int getSentidoDac() {
        return this.SentidoDac;
    }

    public void setSentidoDac(int SentidoDac) {
        this.SentidoDac = SentidoDac;
    }

    public String getDatos_Ciclo() {
        return this.Datos_Ciclo;
    }

    public void setDatos_Ciclo(String Datos_Ciclo) {
        this.Datos_Ciclo = Datos_Ciclo;
    }

    public String getEstado_peanas() {
        return this.Estado_peanas;
    }

    public void setEstado_peanas(String Estado_peanas) {
        this.Estado_peanas = Estado_peanas;
    }

    public float getSegVial() {
        return this.SegVial;
    }

    public void setSegVial(float SegVial) {
        this.SegVial = SegVial;
    }

    public int getTipoTurno() {
        return this.TipoTurno;
    }

    public void setTipoTurno(int TipoTurno) {
        this.TipoTurno = TipoTurno;
    }

    public int getConciliado() {
        return this.Conciliado;
    }

    public void setConciliado(int Conciliado) {
        this.Conciliado = Conciliado;
    }

    public String getNConciliacion() {
        return this.NConciliacion;
    }

    public void setNConciliacion(String NConciliacion) {
        this.NConciliacion = NConciliacion;
    }

    public String getCODIGO_VERIFICACION() {
        return this.CODIGO_VERIFICACION;
    }

    public void setCODIGO_VERIFICACION(String CODIGO_VERIFICACION) {
        this.CODIGO_VERIFICACION = CODIGO_VERIFICACION;
    }

    public Date getProcesado1() {
        return this.Procesado1;
    }

    public void setProcesado1(Date Procesado1) {
        this.Procesado1 = Procesado1;
    }

    public Date getProcesado2() {
        return this.Procesado2;
    }

    public void setProcesado2(Date Procesado2) {
        this.Procesado2 = Procesado2;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAnrp_placa() {
        return this.anrp_placa;
    }

    public void setAnrp_placa(String anrp_placa) {
        this.anrp_placa = anrp_placa;
    }

    public float getAnrp_confiabilidad() {
        return this.anrp_confiabilidad;
    }

    public void setAnrp_confiabilidad(float anrp_confiabilidad) {
        this.anrp_confiabilidad = anrp_confiabilidad;
    }

    public String getAnrp_json_info() {
        return this.anrp_json_info;
    }

    public void setAnrp_json_info(String anrp_json_info) {
        this.anrp_json_info = anrp_json_info;
    }

    public float getTarifaPlena() {
        return TarifaPlena;
    }

    public void setTarifaPlena(float TarifaPlena) {
        this.TarifaPlena = TarifaPlena;
    }

    public String getCliente_uuid() {
        return cliente_uuid;
    }

    public void setCliente_uuid(String cliente_uuid) {
        this.cliente_uuid = cliente_uuid;
    }

    public String getClave_acceso() {
        return clave_acceso;
    }

    public void setClave_acceso(String clave_acceso) {
        this.clave_acceso = clave_acceso;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


    @Override
    public String toString() {
        return "FtsTransaction{" + "Serial=" + Serial + ", FechaAperturaTurno=" + FechaAperturaTurno + ", IdPeaje=" + IdPeaje + ", CarrilAperturaTurno=" + CarrilAperturaTurno + ", CarrilTab=" + CarrilTab + ", CodigoOperador=" + CodigoOperador + ", NombreOperador=" + NombreOperador + ", ApellidoOperador=" + ApellidoOperador + ", Cargo=" + Cargo + ", TurnoTab=" + TurnoTab + ", FechaTab=" + FechaTab + ", CategoriaTab=" + CategoriaTab + ", TipoEjeTab=" + TipoEjeTab + ", CantidadEjesTab=" + CantidadEjesTab + ", TipoPagoTab=" + TipoPagoTab + ", TipoEspecialTab=" + TipoEspecialTab + ", TipoPagoEjeTab=" + TipoPagoEjeTab + ", PrecioTab=" + PrecioTab + ", PrecioEjesTab=" + PrecioEjesTab + ", PlacaDigitada=" + PlacaDigitada + ", SentidoTab=" + SentidoTab + ", TiqueteTab=" + TiqueteTab + ", IdFoto=" + IdFoto + ", Tipo_Dispositivo=" + Tipo_Dispositivo + ", Id_Dispositivo=" + Id_Dispositivo + ", Dato_Saldo=" + Dato_Saldo + ", Dato_Cat=" + Dato_Cat + ", Dato_Nombre=" + Dato_Nombre + ", Dato_Apellido=" + Dato_Apellido + ", Dato_Cedula=" + Dato_Cedula + ", Dato_Placa=" + Dato_Placa + ", Dato_Color=" + Dato_Color + ", Dato_Tp_Invias=" + Dato_Tp_Invias + ", FechaDac=" + FechaDac + ", CatDac=" + CatDac + ", EjesDac=" + EjesDac + ", EjesAdDac=" + EjesAdDac + ", EjesDoblesDac=" + EjesDoblesDac + ", SentidoDac=" + SentidoDac + ", Datos_Ciclo=" + Datos_Ciclo + ", Estado_peanas=" + Estado_peanas + ", SegVial=" + SegVial + ", TipoTurno=" + TipoTurno + ", Conciliado=" + Conciliado + ", NConciliacion=" + NConciliacion + ", CODIGO_VERIFICACION=" + CODIGO_VERIFICACION + ", Procesado1=" + Procesado1 + ", Procesado2=" + Procesado2 + ", uuid=" + uuid + ", anrp_placa=" + anrp_placa + ", anrp_confiabilidad=" + anrp_confiabilidad + ", anrp_json_info=" + anrp_json_info + ", TarifaPlena=" + TarifaPlena + ", cliente_uuid=" + cliente_uuid + '}';
    }

}
    
    
    

