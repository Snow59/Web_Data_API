BONJOUR   les KHEYYYYYYYYYYYZS


je propose que je fais l'api authentification je vais mettre en place un chiffrement AES et vous vous occuper de JEUX 

Pour les cartes à jouer c'est mieux on utilise le fichier JSON des joueurs de Lol qu'on a trouvé sur un autre GitHub

cf : https://github.com/ngryman/lol-champions/blob/master/champions.json

Voila la ligne de commande pour demarrer un docker avec un volume sur un port specific : 

docker run -d -p 27017:27017 -v mongodb_hamza_data:/data/db --name nom_personnalisé mongo

voila la commande qui run le docker compose : docker-compose up -d      

le -d est facultatif c'est si on veut run en back 


Pour mon api il faut faire juste : docker-compose up --build  ça va build les 2 dockers , un pour la DB et un pour l'api 

Ensuite il faut utiliser le fichier " function_multiple_ne_pas_lancer " et touut en bas mettre en commentaire ou non les définition qu'on veut lancer.



