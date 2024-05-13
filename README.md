BONJOUR   les KHEYYYYYYYYYYYZS


je propose que je fais l'api authentification je vais mettre en place un chiffrement AES et vous vous occuper de JEUX 

Pour les cartes à jouer c'est mieux on utilise le fichier JSON des joueurs de Lol qu'on a trouvé sur un autre GitHub

cf : https://github.com/ngryman/lol-champions/blob/master/champions.json

Voila la ligne de commande pour demarrer un docker avec un volume sur un port specific : 

docker run -d -p 27017:27017 -v mongodb_hamza_data:/data/db --name nom_personnalisé mongo

############################
Demarrage Api_auth:

Etape 1 : build l'image docker de l'api , lancer cette commande à la racine du projet :  docker build -t api_python .

on devrait avoir qql chose comme ça : PS C:\Users\hyahiani\PycharmProjects\Aquastar> docker build -t api_python .
[+] Building 7.4s (10/10) FINISHED                                                                                                       docker:default
 => [internal] load build definition from Dockerfile                                                                                               0.0s
 => => transferring dockerfile: 239B                                                                                                               0.0s 
 => [internal] load metadata for docker.io/library/python:3.8-slim  

 Etape 2 : on lance la commande : docker compose up -d

ça va telecharger et monter l'image mongo et ensuite run les 2 dockers 1 avec la DB et 1 avec l'api.
   
le -d est facultatif c'est si on veut run en back 


Pour mon api il faut faire juste : docker-compose up --build  ça va build les 2 dockers , un pour la DB et un pour l'api 

Ensuite il faut utiliser le fichier " function_multiple_ne_pas_lancer " et touut en bas mettre en commentaire ou non les définition qu'on veut lancer.

On lance en premier la " create_account() " qui  va créé et ajouté un compte dans la DB   il suffit d'enlever le # et le mettre sur les autres nom 

Ensuite "login() " et normalement un token est retourné dans la console.

On récupére ce token et on le colle dans le headers de la fonction " checktoken() "  et on lance cette fonction , l'api retournera que le token est valide avec un http_status en 200. 



