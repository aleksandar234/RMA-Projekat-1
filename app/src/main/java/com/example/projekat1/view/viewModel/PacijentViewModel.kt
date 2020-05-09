package com.example.projekat1.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projekat1.model.Pacijent
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class PacijentViewModel : ViewModel() {

    private val pacijentListCekaonica : MutableList<Pacijent> = mutableListOf()
    private val pacijentListHospitalizovani : MutableList<Pacijent> = mutableListOf()
    private val pacijentListOtpusteni : MutableList<Pacijent> = mutableListOf()
    private val pacijentiCekaonice : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val pacijentiHospitalizacije : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val pacijentiOtpusteni : MutableLiveData<List<Pacijent>> = MutableLiveData()


    init {
        val sdf = SimpleDateFormat("M.dd.yyyy")
        val currentDate = sdf.format(Date())
        pacijentListCekaonica.add(
            Pacijent(
                "Nikola",
                "Nikolic",
                "Pacijent ima povisenu temperaturu i bolove u misicima",
                "Pacijent ima povisenu temperaturu i bolove u misicima",
                0,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListCekaonica.add(
            Pacijent(
                "Petar",
                "Peric",
                "Pacijent ima bolove u misicima",
                "Pacijent ima bolove u misicima",
                4,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListCekaonica.add(
            Pacijent(
                "Milos",
                "Milosevic",
                "Pacijent kaslje i ima bolove u plucima",
                "Pacijent kaslje i ima bolove u plucima",
                1,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListCekaonica.add(
            Pacijent(
                "Lazar",
                "Lazic",
                "Pacijent ima povisenu temperaturu i upalu krajnika",
                "Pacijent ima povisenu temperaturu i upalu krajnika",
                2,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListHospitalizovani.add(
            Pacijent(
                "Miodrag",
                "Miletic",
                "Pacijent ima jake bolove u stomaku",
                "Pacijent ima jake bolove u stomaku",
                3,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListHospitalizovani.add(
            Pacijent(
                "Stefan",
                "Vasic",
                "Pacijent ima upalu grla",
                "Pacijent ima upalu grla",
                5,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListOtpusteni.add(
            Pacijent(
                "Nemanja",
                "Nedeljkovic",
                "Pacijent ima migrenu",
                "Pacijent ima migrenu",
                6,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListOtpusteni.add(
            Pacijent(
                "Svetozar",
                "Brankovic",
                "Pacijent je hronicki bolesnik",
                "Pacijent je hronicki bolesnik",
                7,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        pacijentListOtpusteni.add(
            Pacijent(
                "Relja",
                "Samardzic",
                "Pacijent se zali na jake bolove u ledjima",
                "Pacijent se zali na jake bolove u ledjima",
                8,
                "https://thumbs.dreamstime.com/t/senior-man-sleeping-bed-morning-healthy-rest-recovery-time-senior-man-sleeping-bed-morning-healthy-rest-106271796.jpg",
                currentDate.toString()
            )
        )
        val l1 = mutableListOf<Pacijent>()
        l1.addAll(pacijentListCekaonica)
        pacijentiCekaonice.value = l1
        val l2 = mutableListOf<Pacijent>()
        l2.addAll(pacijentListHospitalizovani)
        pacijentiHospitalizacije.value = l2
        val l3 = mutableListOf<Pacijent>()
        l3.addAll(pacijentListOtpusteni)
        pacijentiOtpusteni.value = l3

    }

    fun updateKarton(pacijent: Pacijent){
        val stari = pacijentListHospitalizovani.find {it.id == pacijent.id}
        val i = pacijentListHospitalizovani.indexOf(stari)
        pacijentListHospitalizovani.remove(stari)
        pacijentListHospitalizovani.add(i,pacijent)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(pacijentListHospitalizovani)
        pacijentiHospitalizacije.value = listToSubmit
    }

    fun addHospitolize(patient: Pacijent){
        pacijentListCekaonica.remove(patient)
        val list1 = mutableListOf<Pacijent>()
        list1.addAll(pacijentListCekaonica)
        pacijentiCekaonice.value =list1
        pacijentListHospitalizovani.add(patient)
        val list2 = mutableListOf<Pacijent>()
        list2.addAll(pacijentListHospitalizovani)
        pacijentiHospitalizacije.value = list2
    }

    fun dodajUOtpust(patient: Pacijent){
        pacijentListHospitalizovani.remove(patient)
        val list1 = mutableListOf<Pacijent>()
        list1.addAll(pacijentListHospitalizovani)
        pacijentiHospitalizacije.value = list1
        pacijentListOtpusteni.add(patient)
        val list2 = mutableListOf<Pacijent>()
        list2.addAll(pacijentListOtpusteni)
        pacijentiOtpusteni.value = list2
    }

    fun addPacijent(patient: Pacijent){
        pacijentListCekaonica.add(patient)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(pacijentListCekaonica)
        pacijentiCekaonice.value = listToSubmit
    }

    fun removePacijent(patient: Pacijent){
        pacijentListCekaonica.remove(patient)
        val list = mutableListOf<Pacijent>()
        list.addAll(pacijentListCekaonica)
        pacijentiCekaonice.value = list
    }

    fun getPacijenteCekaonice() : LiveData<List<Pacijent>>{
        return pacijentiCekaonice
    }

    fun getPacijenteHospitalizacije() : LiveData<List<Pacijent>>{
        return pacijentiHospitalizacije
    }

    fun getPacijenteOtpustene() : LiveData<List<Pacijent>>{
        return pacijentiOtpusteni
    }


    fun filterPacijentCekaonica(filter : String){
        val filterList = pacijentListCekaonica.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) ||
            it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        pacijentiCekaonice.value = filterList
    }

    fun filterPacijentHospitalizovani(filter : String){
        val filterList = pacijentListHospitalizovani.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        pacijentiHospitalizacije.value = filterList
    }

    fun filterPacijentOtpusteni(filter : String){
        val filterList = pacijentListOtpusteni.filter {
            it.ime.toLowerCase().contains(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().contains(filter.toLowerCase())
        }
        pacijentiOtpusteni.value = filterList
    }

    fun brojCekaonica() : Int {
        return pacijentListCekaonica.size
    }

    fun brojHospitalizacija() : Int {
        return pacijentListHospitalizovani.size
    }

    fun brojOtpusteni() : Int {
        return pacijentListOtpusteni.size
    }

}