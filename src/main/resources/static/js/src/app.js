$(document).ready(function() {
    var noteTitle = $("#note-title"),
        noteContent = $("#note-content"),
        addNoteButton = $("#add-note-button"),
        notePriority = $("#priority"),
        modal = $('#myModal');

    function addEventListenerToModal() {
        modal.on('shown.bs.modal', function () {
            $('#myInput').focus();
        })
    }

    function addEventListenerToAddNoteButton() {
        addNoteButton.click(function() {
            var data = {
                noteTitle: noteTitle.val(),
                noteContent: noteContent.val(),
                notePriority: notePriority.val()
            }
            var json = JSON.stringify(data);

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/addNote",
                data: json,
                contentType: "application/json",
                success: function() {
                    console.log("Request sent!");
                    console.log(json);
                }
            })
        });
    }

    addEventListenerToModal();
    addEventListenerToAddNoteButton();
})