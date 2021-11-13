package com.example.covsymps;

public class Covid_Symtoms_Spin {
    float Fever;
    float RunnyNose;
    float HeadAche;
    float Cold;
    float Nausea;
    float Diarrhoea;
    float SoreThroat;
    float MuscleAche;
    float LossSmellTaste;
    float ShortBreath;
    float Tired;
    float Cough;
    float HeartRate;
    float RespRate;

    public Covid_Symtoms_Spin(float fever, float runnyNose, float headAche, float cold, float nausea,float diarrhoea,float soreThroat,float muscleAche,float lossSmellTaste,float shortBreath, float tired,float cough,float heartRate,float respRate) {
        Fever = fever;
        RunnyNose = runnyNose;
        HeadAche = headAche;
        Cold = cold;
        Nausea = nausea;
        Diarrhoea = diarrhoea;
        SoreThroat = soreThroat;
        MuscleAche = muscleAche;
        LossSmellTaste = lossSmellTaste;
        ShortBreath = shortBreath;
        Tired = tired;
        Cough = cough;
        HeartRate = heartRate;
        RespRate = respRate;

    }

    Covid_Symtoms_Spin()
    {

    }
    public float getFever() {
        return Fever;
    }

    public void setFever(float fever) {
        Fever = fever;
    }

    public float getRunnyNose() {
        return RunnyNose;
    }

    public void setRunnyNose(float runnyNose) {
        RunnyNose = runnyNose;
    }

    public float getHeadAche() {
        return HeadAche;
    }

    public void setHeadAche(float headAche) {
        HeadAche = headAche;
    }

    public float getCold() {
        return Cold;
    }

    public void setCold(float cold) {
        Cold = cold;
    }

    public void setDiarrhoea(float diarrhoea) {
        Diarrhoea = diarrhoea;
    }
    public float getDiarrhoea() {
        return Diarrhoea;
    }

    public void setLossSmellTaste(float lossSmellTaste) {
        LossSmellTaste = lossSmellTaste;
    }

    public float getLossSmellTaste() {
        return LossSmellTaste;
    }

    public void setMuscleAche(float muscleAche) {
        MuscleAche = muscleAche;
    }

    public float getMuscleAche() {
        return MuscleAche;
    }

    public void setNausea(float nausea) {
        Nausea = nausea;
    }

    public float getNausea() {
        return Nausea;
    }

    public void setTired(float tired) {
        Tired = tired;
    }

    public float getTired() {
        return Tired;
    }

    public void setSoreThroat(float soreThroat) {
        SoreThroat = soreThroat;
    }

    public float getSoreThroat() {
        return SoreThroat;
    }

    public float getShortBreath() {
        return ShortBreath;
    }

    public void setShortBreath(float shortBreath) {
        ShortBreath = shortBreath;
    }

    public float getCough() {
        return Cough;
    }

    public void setCough(float cough) {
        Cough = cough;
    }

    public float getHeartRate() {
        return HeartRate;
    }

    public void setHeartRate(float heartRate) {
        HeartRate = heartRate;
    }

    public float getRespiratoryRate() {
        return RespRate;
    }

    public void setRespiratoryRate(float respRate){
        RespRate = respRate;
    }
}
