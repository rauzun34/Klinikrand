function getPatientByBurgerID() {

  const BurgerID = document.getElementById("c_BurgerID").value;


  // fetch(`API_URL/${BurgerID}`)
  //   .then(response => response.json())
  //   .then(patient => {
      // Gelen hastanın bilgilerini form elemanlarına doldur
      patient={
          "Name":"Ali",
          "Nachname":"Veli",
          "Telefonnummer": "344234234",
          "Status": 1,
          "Anmerkungen":"NOT FALAN"
      }
      document.getElementById("c_Name").value = patient.Name;
      document.getElementById("c_Nachname").value = patient.Nachname;
      document.getElementById("c_Telefonnummer").value = patient.Telefonnummer;
      document.getElementById("c_Status").value = patient.Status;
      document.getElementById("c_Anmerkungen").value = patient.Anmerkung;
  //   })
  //   .catch(error => {
  //     console.error("Hasta bilgileri alınırken hata oluştu:", error);
  //   });
}

function updatePatient(patient) {

  fetch(`API_URL/${patient.id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(patient)
  })
    .then(response => {
      if (response.ok) {
        console.log("Die Patient-Informationen sind aktualisiert.");
      } else {
        console.error("Ups!!Etwas bei der Aktualisierung der Patient-Informationen Schiff gegangen.");
      }
    })
    .catch(error => {
      console.error("Ups! Etwas bei der Aktualisierung der Patient-Informationen Schiff gegangen:", error);
    });
}



document.getElementById("update-kunde-button").addEventListener("click", () => {
  const id = document.getElementById("c_Kunde-id").value;
  const Name = document.getElementById("c_Name").value;
  const Nachname = document.getElementById("c_Nachname").value;
  const Telefonnummer = document.getElementById("c_Telefonnummer").value;
  const Status = document.getElementById("c_Status").value;
  const Anmerkung = document.getElementById("c_notes").value;

 const updatedPatient = {
  id: id,
  Name: Name,
  Nachname: Nachname,
  Telefonnummer: Telefonnummer,
  Status: Status,
  Anmerkung: Anmerkung
};

updatePatient(updatedPatient);
});

function updatePatient(patient) {

fetch(`API_URL/${patient.id}`, {
  method: 'PUT',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(patient)
})
  .then(response => {
    if (response.ok) {
      console.log('Die Patient-Informationen sind aktualisiert.');
    } else {
      console.error('Ups!!Etwas bei der Aktualisierung der Patient-Informationen Schiff gegangen.');
    }
  })
  .catch(error => {
    console.error('Ups!!Etwas bei der Aktualisierung der Patient-Informationen Schiff gegangen:', error);
  });
}