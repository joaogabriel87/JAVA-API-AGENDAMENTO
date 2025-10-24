# API DE RESERVA DE SALA DE REUNIÃO

## DESCRIÇAO
API para realizar o gerenciamento da sala de reunião da empresa

## TECNOLOGIAS USADAS
- **Java 21**
- **Spring Boot**
- **Maven**
- **Banco de Dados H2**

### COMO USAR
GIT CLONE: https://github.com/joaogabriel87/JAVA-API-AGENDAMENTO.git

ABRA O PROJETO NA SUA IDE

RODE O APP(Projeto configurado para rodar na porta 8080)

# ENDPOINTS
1. **Criar sala**

 POST: /api/room

       `{
        "emailUser": "joao.gabriel@email.com",
        "room": "Sala Reunião 01"
       }`

2. **Criar usuario**

POST: /api/user

       `{
       "name": "João Gabriel",
       "email": "joao.gabriel@email.com",
       "department": "TI"
       }`


3. **Criar Reserva**

POST: /api/booking

    `{
       "title": "Reunião de Alinhamento",
       "data": "2025-10-24",
       "hour_inicial": "12:00:00",
       "hour_final": "13:00:00",
       "emailUser": "joagabriel9@email.com",
       "roomName": "Sala Reunião 01"
       }`

4. **Consultar reserva de uma sala**

    GET: /api/booking

          `{
            "emailUser": "joao.gabriel@email.com",
            "room": "Sala Reunião 01"
           }`


5. **Editar a reserva**

    PATCH: /api/booking/edit/{id_booking}
    Exemplo: /api/booking/edit/1
`

        `{
        "title": "Reunião de Alinhamento 3",
        "data": "2025-10-24",
        "hour_inicial": "11:00:00",
        "hour_final": "12:00:00"
        }`


## Status code Erros:
- 404 NOT FOUND: Sala, usuario e reserva não encontrados
- 409 CONFLICT: Sala, usuario já criados
- 400 BAD REQUEST: Sala já ocupada no horario
