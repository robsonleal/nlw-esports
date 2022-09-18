import { useState, useEffect } from 'react';
import { Image, FlatList } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { useNavigation } from '@react-navigation/native';

import logoImg from '../../assets/logo-nlw-esports.png';

import { Background } from '../../components/Background';
import { GameCard, GameCardProps } from '../../components/GameCard';
import { Heading } from '../../components/Heading';

import { styles } from './styles';

export function Home() {
  const[games, setGames] = useState<GameCardProps[]>([]);

  useEffect(() => {
    fetch('http://192.168.1.2:8080/games')
      .then(response => response.json())
      .then(data => setGames(data))
  }, []);

  const navigation = useNavigation();

  function handleOpenGame({id, title, bannerUrl}: GameCardProps) {
    navigation.navigate('game', {id, title, bannerUrl});
  }

  return (
    <Background>
      <SafeAreaView style={styles.container}>
        <Image
          source={logoImg}
          style={styles.logo}
        />

        <Heading 
          title="Encontre o seu duo!"
          subtitle="Selecione o game que deseja jogar..."
        />

        <FlatList
          contentContainerStyle={styles.contentList}
          data={games}
          keyExtractor={item => item.id}
          horizontal
          showsHorizontalScrollIndicator={false}
          renderItem= {({item}) => (
            <GameCard
              data={item}
              onPress={() => handleOpenGame(item)}
            />
          )}
        />
      </SafeAreaView>
    </Background>
  );
}