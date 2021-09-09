$(document).ready(()=>{
    let registrationToEdit = null;

$('#add-registration-button').click(()=>{
    if(registrationToEdit){
        editRegistration(registrationToEdit);
        }else{
        addNew();
        }
    });

    function editRegistration(registrationToEdit){
       const firstname=$('#modal-guest-firstname').val();
       const lastname=$('#modal-guest-lastname').val();
       const notes=$('#modal-guest-notes').val();
       const phone=$('#modal-guest-phone').val();

        fetch(`/api/registrations/${registrationToEdit}`, {
           method: 'PUT',
           body: JSON.stringify ({
               firstname:firstname,
               lastname:lastname,
               notes:notes,
               phone:phone
           }),
               headers: {
                       'Content-Type': 'application/json'
                   }
               }).then(response =>{
                   if(response.ok){
                   location.reload();
                   }else{
                   alert("There was an error generating you details" + response.status);
                   }
               });

           }

    function addNew(){
    const firstname=$('#modal-guest-firstname').val();
    const lastname=$('#modal-guest-lastname').val();
    const notes=$('#modal-guest-notes').val();
    const phone=$('#modal-guest-phone').val();

    fetch('/api/registrations', {
    method: 'POST',
    body: JSON.stringify ({
        firstname:firstname,
        lastname:lastname,
        notes:notes,
        phone:phone
    }),
        headers: {
                'Content-Type': 'application/json'
            }
        }).then(response =>{
            if(response.ok){
            location.reload();
            clearModal();
            }else{
            alert("There was an error generating your details" + response.status);
            }
        });

    }

    function clearModal(){
    $('#modal-guest-firstname').val('');
    $('#modal-guest-lastname').val('');
    $('#modal-guest-notes').val('');
    $('#modal-guest-phone').val('');
    }

    $('.delete-icon').click(function() {
    const registrationId = this.parentElement.id;
    fetch(`api/registrations/${registrationId}`,{
        method:'DELETE'
    }).then(response=>location.reload());

    });

    $('.edit-icon').click(function() {
     registrationToEdit = this.parentElement.id;
     const row = this.parentElement.parentElement.parentElement;
     const firstname = row.children[1].innerText;
     const lastname = row.children[2].innerText;
     const notes = row.children[3].innerText;
     const phone = row.children[4].innerText;

     $('#modal-guest-firstname').val(firstname);
     $('#modal-guest-lastname').val(lastname);
     $('#modal-guest-notes').val(notes);
     $('#modal-guest-phone').val(phone);

    });

    $('#add-registration-main-button').click(() => {
        clearModal();
        registrationToEdit = null;

    });

});
