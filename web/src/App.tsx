import { useEffect, useState } from 'react';
import * as Dialog from '@radix-ui/react-dialog';

import { GameBanner } from './components/GameBanner'
import { CreateAdBanner } from './components/CreateAdBanner';
import { CreateAdModal } from './components/CreateAdModal';

import logoImg from './assets/logo-nlw-esports.svg';

import './styles/main.css';

interface Game {
  id: string;
  title: string;
  bannerUrl: string;
  count: {
    ads: number;
  }
}

function App() {
  const[games, setGames] = useState<Game[]>([]);

  useEffect(() => {
    fetch('http://localhost:8080/games')
      .then(response => response.json())
      .then(data => {
        setGames(data);
      })
  }, [])

  return (
    <div className="max-w-[1344px] mx-auto flex flex-col items-center my-20">
      <img src={logoImg} alt="" className='mb-20' />

      <h1 className="text-6xl text-white font-black">
        Seu <span className="bg-nlw-gradient bg-clip-text text-transparent">duo</span> está aqui.
      </h1>

      <div className="grid grid-cols-6 gap-6 mt-16">
        {games.map(game => {
          return (
            <GameBanner 
              key={game.id}
              title={game.title}
              bannerUrl={game.bannerUrl}
              adsCount={game.count.ads}
            />
          )
        })}
      </div>

      <Dialog.Root>
        <CreateAdBanner />
        
        <CreateAdModal />
      </Dialog.Root>
    </div>
  )
}

export default App
