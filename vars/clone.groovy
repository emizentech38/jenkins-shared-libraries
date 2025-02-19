def call(url , branch){
  echo "this is fetching the code"
  git url: "${url}" , branch: "${branch}"
  echo "code cloning successfull"
}
