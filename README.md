# -Request-Acknowledge-Poll.

implémentation du pattern: Request/Acknowledge/Poll.
Nous supposons que le client fait appel au web service pour une requête qui ne peut pas être résolue immédiatement.
A implémenter:
• La classe ClientMain qui doit :
o Envoyer une requête au service1 avec l’url :
Domain/Application/service1/number
o Vérifier le status de la réponse
o Récupérer l’url du service qui va répondre (service2) dans le header «Location »
o Rediriger la requête vers service2

o Vérifier le status de la réponse du service2, et répéter la requête tant que la
réponse n’est pas encore prête.
• Le web service Service1 est sensé répondre à une requête qui demande un certain
temps de calcule, pour cela il lance un CalculeThread qui va mettre à jour la
« DataBase » une fois le calcule términé:
o Lance le Thread new CalculeThread().start
o Retourner le status accepted pour informer le client que la requête est prise en
compte, mais qu’il faudrait solliciter le service2, pour cela il faudrait retourner
l’url du service2 qui va prendre en charge la requête
• Le web service Service2 :
o Vérifier si la réponse est prête :new DataBase().reponsePrete()
o Retourné la réponse lorsqu’elle est prête
Fournis :
DataBase une classe qui implémente la méthode reponsePrete() qui retourne un boolean
lorsque la req
