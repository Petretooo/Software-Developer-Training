
const getWordsByPage = 'http://localhost:8080/hangman/api/v1/words';
const deleteWord = 'http://localhost:8080/hangman/api/v1/words/';
const postWord= 'http://localhost:8080/hangman/api/v1/words';


class GameService{
    
    getWordsByPage(page){  
        return fetch(`${getWordsByPage}?page=${page}`).then(res => res.json())
    }

    postWord(wordName, level){
        return fetch(postWord + `?wordName=${wordName}&level=${level}`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }

    deleteWord(data){
        return fetch(deleteWord + `/${data}`,{
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }
}

export default new GameService();