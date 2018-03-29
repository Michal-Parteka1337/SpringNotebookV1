$(document).ready(function() {
    var noteTitle = $("#note-title"),
        noteContent = $("#note-content"),
        addNoteButton = $("#add-note-button"),
        notePriorityDropdown = $("#priority"),
        userName = $("#userName"),
        modal = $('#myModal'),
        notePriorityDropdownContent;

    function addEventListenerToModal() {
        modal.on('shown.bs.modal', function () {
            $('#myInput').focus();
        })
    }

    function addEventListenerToPriorityDropdown() {
        notePriorityDropdown.on('click', function(e){
            notePriorityDropdownContent = e.target.text;
        })
    }

    function addEventListenerToAddNoteButton() {
        addNoteButton.click(function() {
            var data = {
                noteTitle: noteTitle.val(),
                noteContent: noteContent.val(),
                notePriority: notePriorityDropdownContent,
                userName: userName.val()
            }
            var json = JSON.stringify(data);
            console.log(json);
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/addNote",
                data: json,
                contentType: "application/json",
                success: function() {
                    location.reload();
                }
            })
        });
    }

    addEventListenerToModal();
    addEventListenerToPriorityDropdown();
    addEventListenerToAddNoteButton();
})